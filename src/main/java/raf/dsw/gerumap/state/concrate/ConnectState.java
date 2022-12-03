package raf.dsw.gerumap.state.concrate;

import raf.dsw.gerumap.gui.swing.view.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.gui.swing.view.PojamPainter;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.Veza;
import raf.dsw.gerumap.state.State;

import java.awt.*;

public class ConnectState extends State {

    @Override
    public void pressed(int x, int y, MindMapView m) {

        //Lazni pojam koji koristimo samo za testiranje
        Veza veza = new Veza(new Pojam(new Dimension(10, 10), new Point(x, y)));
        for (ElementPainter elementPainter : m.getElementPainterList()) {
            if (elementPainter instanceof PojamPainter && elementPainter.elementAt(veza.getFrom(), veza.getFrom().getPosition())) {

            }
        }
        System.out.println("Connect");
    }

    @Override
    public void released(Point pointStart, Point pointEnd, MindMapView m) {
        super.released(pointStart, pointEnd, m);
    }

    @Override
    public void moved(Point pointStart, Point pointEnd, MindMapView m) {

        super.moved(pointStart, pointEnd, m);
    }
}
