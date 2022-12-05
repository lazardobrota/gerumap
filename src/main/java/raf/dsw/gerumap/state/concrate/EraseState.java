package raf.dsw.gerumap.state.concrate;

import raf.dsw.gerumap.gui.swing.view.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.Veza;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.util.Iterator;

public class EraseState extends State {

    @Override
    public void pressed(int x, int y, MindMapView m) {

        //Lazni pojam koji koristimo kao hitbox kursora
        Pojam pojam = new Pojam(new Dimension(10, 10), new Point(x, y));
        boolean t = true;


        Iterator<ElementPainter> iterator = m.getElementPainterList().iterator();
        while (iterator.hasNext()) {

            ElementPainter elementPainter = iterator.next();
            if (!elementPainter.elementAt(pojam, pojam.getPosition()))//Taj element nije selektovan pa nastavi dalje da trazis
                continue;

            /*
            if (elementPainter.getElement() instanceof Pojam) {//Ako je pojam moramo da proverimo da li moramo i njegove veze da brisemo
                Pojam p = (Pojam) elementPainter.getElement();
                t = isAlone(p, m);
            }
             */
            elementPainter.getElement().setParent(null);//Sklanja mu roditelja
            m.getElementPainterList().remove(elementPainter);//Listi paintera sklanja taj elementPainter
            m.getMindMap().deleteChild(elementPainter.getElement());//Roditelju sklanja taj element

            System.out.println("Erase");
            return;
        }
    }

    private boolean isAlone(Pojam pojam, MindMapView mindMapView) {

        Iterator<ElementPainter> iterator = mindMapView.getElementPainterList().iterator();
        while (iterator.hasNext()) {
            ElementPainter elementPainter = iterator.next();
            if (elementPainter.getElement() instanceof Veza) {

            }
        }

        return false;
    }
}
