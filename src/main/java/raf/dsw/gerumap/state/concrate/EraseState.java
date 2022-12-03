package raf.dsw.gerumap.state.concrate;

import raf.dsw.gerumap.gui.swing.view.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.util.Iterator;

public class EraseState extends State {

    @Override
    public void pressed(int x, int y, MindMapView m) {

        //Lazni pojam koji koristimo kao hitbox kursora
        Pojam pojam = new Pojam(new Dimension(10, 10), new Point(x, y));


        Iterator<ElementPainter> iterator = m.getElementPainterList().iterator();
        while (iterator.hasNext()) {

            ElementPainter elementPainter = iterator.next();
            if (elementPainter.elementAt(pojam, pojam.getPosition())) {

                elementPainter.getElement().setParent(null);//Sklanja mu roditelja
                m.getMindMap().deleteChild(elementPainter.getElement());//Roditelju sklanja taj element
                m.getElementPainterList().remove(elementPainter);//Listi paintera sklanja taj elementPainter

                System.out.println("Erase");
                return;
            }
        }
    }
}
