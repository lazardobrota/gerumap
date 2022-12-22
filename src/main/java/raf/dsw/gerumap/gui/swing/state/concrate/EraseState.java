package raf.dsw.gerumap.gui.swing.state.concrate;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.view.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.commands.impl.EraseElementCommand;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.Veza;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EraseState extends State {

    List<Element> elements = new ArrayList<>();

    @Override
    public void pressed(int x, int y, MindMapView m) {

        List<Pojam> brisanje = new ArrayList<>();//Cuvamo pojam koji se brise da bi obrisali njegove veze
        elements.clear(); //Restartuje brisanje veza za sledece brisanje

        if (!m.getMapSelectionModel().getSelectedElements().isEmpty()) {//Ako je nesto selektovano

            Iterator<ElementPainter> iteratorPainter = m.getElementPainterList().iterator();

            //Prolazi kroz sve Paintere
            while (iteratorPainter.hasNext()) {
                Element elementPainter = iteratorPainter.next().getElement();
                //Ako su im ista imena nasli smo element koji trebamo svuda da uklonimo
                if (m.getMapSelectionModel().getSelectedElements().contains(elementPainter)) {
                  brisanje.add((Pojam) elementPainter);//Selektovani mogu samo pojmovi da budu
                }
            }

            elements.addAll(brisanje);//Dodaje u listu svih elementata za undo i redo
            for (Pojam pojam : brisanje) {
                removeConnections(pojam, m);//Brise svaku vezu koju su imali
            }

            AbstractCommand command = new EraseElementCommand(m.getMindMap(), elements, m.getMapSelectionModel().getSelectedElements());
            m.getMindMap().getCommandManager().addCommand(command);
            return;
        }


        //Lazni pojam koji koristimo kao hitbox kursora
        Pojam pojam = new Pojam(new Dimension(10, 10), new Point(x, y));

        Iterator<ElementPainter> iterator = m.getElementPainterList().iterator();
        while (iterator.hasNext()) {

            ElementPainter elementPainter = iterator.next();
            if (!elementPainter.elementAt(pojam, pojam.getPosition()))//Taj element nije selektovan pa nastavi dalje da trazis
                continue;

            if (elementPainter.getElement() instanceof Pojam) {//Ako je pojam moramo da proverimo da li moramo i njegove veze da brisemo
                brisanje.add((Pojam) elementPainter.getElement());
            }
            elements.add(elementPainter.getElement());//Dodaje u listu svih elementata za undo i redo
            System.out.println("Erase");
            break;
        }


        for (Pojam p : brisanje) {
            removeConnections(p, m);//mora van jer ne moze iterator unutar iteratora da prolazi
        }

        AbstractCommand command = new EraseElementCommand(m.getMindMap(), elements, m.getMapSelectionModel().getSelectedElements());
        m.getMindMap().getCommandManager().addCommand(command);
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
                    if (!elements.contains(veza))//Da se ne bi dva puta dodavala ista veza ako je dva pojma koji se brisu imaju
                        elements.add(veza);
                }
            }
        }
    }
}
