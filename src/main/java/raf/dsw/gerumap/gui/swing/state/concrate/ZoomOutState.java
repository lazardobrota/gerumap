package raf.dsw.gerumap.gui.swing.state.concrate;

import raf.dsw.gerumap.gui.swing.state.State;
import raf.dsw.gerumap.gui.swing.view.MindMapView;

import java.awt.geom.Point2D;

public class ZoomOutState extends State {
    @Override
    public void pressed(int x, int y, MindMapView m) {

        //Ne moze vise od ovoga da odzumira
        if (m.getZoom() <= 0.5) {
            return;
        }

        m.setZoom(m.getZoom() * 0.8);
        if (0.9 <= m.getZoom() && m.getZoom() <= 1.1) //Ako je oko 1 da se restartuje na 1
            m.setZoom(1);

        m.setupTranformation();
        m.repaint();
        System.out.println("ZoomOut");
    }
}
