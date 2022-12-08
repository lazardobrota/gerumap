package raf.dsw.gerumap.gui.swing.state.concrate;

import raf.dsw.gerumap.gui.swing.view.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.Veza;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.*;
import java.util.Iterator;

public class EraseState extends State {

    @Override
    public void pressed(int x, int y, MindMapView m) {

        if (!m.getMapSelectionModel().getSelectedElements().isEmpty()) {//Ako je nesto selektovano

            Iterator<ElementPainter> iteratorPainter = m.getElementPainterList().iterator();
            Pojam[] brisanje = new Pojam[m.getMapSelectionModel().getSelectedElements().size()];//Pravi niz
            int i = 0;

            //Prolazi kroz sve Paintere
            while (iteratorPainter.hasNext()) {
                Element elementPainter = iteratorPainter.next().getElement();
                //Ako su im ista imena nasli smo element koji trebamo svuda da uklonimo
                if (m.getMapSelectionModel().getSelectedElements().contains(elementPainter)) {
                  brisanje[i++] = (Pojam) elementPainter;//Selektovani mogu samo pojmovi da budu

                  m.getMindMap().deleteChild(elementPainter);//Brise iz mape uma
                  m.getMapSelectionModel().getSelectedElements().remove(elementPainter);//Brise iz selektovanih
                  iteratorPainter.remove();//Brise iz paintera
                }
            }

            for (int j = 0; j < i; j++) {
                removeConnections(brisanje[j], m);//Brise svaku vezu koju su imali
            }

            return;
        }


        //Lazni pojam koji koristimo kao hitbox kursora
        Pojam pojam = new Pojam(new Dimension(10, 10), new Point(x, y));

        Pojam brise = null;//Cuvamo pojam koji se brise da bi obrisali njegove veze


        Iterator<ElementPainter> iterator = m.getElementPainterList().iterator();
        while (iterator.hasNext()) {

            ElementPainter elementPainter = iterator.next();
            if (!elementPainter.elementAt(pojam, pojam.getPosition()))//Taj element nije selektovan pa nastavi dalje da trazis
                continue;

            if (elementPainter.getElement() instanceof Pojam) {//Ako je pojam moramo da proverimo da li moramo i njegove veze da brisemo
                brise = (Pojam) elementPainter.getElement();
            }
            elementPainter.getElement().setParent(null);//Sklanja mu roditelja
            m.getMindMap().deleteChild(elementPainter.getElement());//Roditelju sklanja taj element
            iterator.remove();//Listi paintera sklanja taj elementPainter

            System.out.println("Erase");
            break;
        }

        if (brise == null)
            return;

        removeConnections(brise, m);//mora van jer ne moze iterator unutar iteratora da prolazi
    }

    //Ako nije pojam sam onda treba i njegove vezu da se obrisu
    private void removeConnections(Pojam pojam, MindMapView mindMapView) {

        Iterator<ElementPainter> iterator = mindMapView.getElementPainterList().iterator();
        while (iterator.hasNext()) {
            ElementPainter elementPainter = iterator.next();
            if (elementPainter.getElement() instanceof Veza) {
                Veza veza = (Veza) elementPainter.getElement();
                //Ako veza ima taj pojam koji se brise kao pocetni ili krajni onda se i ta veza brise
                if (veza.getFrom().equals(pojam) || veza.getTo().equals(pojam)) {
                    mindMapView.getMindMap().deleteChild(veza);//Roditelju sklanja taj element
                    iterator.remove();//Listi paintera sklanja taj elementPainter
                }
            }
        }
    }
}
