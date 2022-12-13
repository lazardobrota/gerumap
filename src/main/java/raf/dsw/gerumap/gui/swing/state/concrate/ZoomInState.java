package raf.dsw.gerumap.gui.swing.state.concrate;

import raf.dsw.gerumap.gui.swing.view.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.gui.swing.state.State;
import raf.dsw.gerumap.gui.swing.view.PojamPainter;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;

import java.awt.*;
import java.awt.geom.Point2D;

public class ZoomInState extends State {


    @Override
    public void pressed(int x, int y, MindMapView m) {

        //Ne moze vise od ovoga da zumira
        if (m.getZoom() >= 2) {
            return;
        }
        m.setZoom(m.getZoom() * 1.2);
        if (0.9 <= m.getZoom() && m.getZoom() <= 1.1)//Ako je oko 1 da se restartuje na 1
            m.setZoom(1);
        m.setupTranformation();
        m.repaint();
        System.out.println("Zoom");
    }
}
