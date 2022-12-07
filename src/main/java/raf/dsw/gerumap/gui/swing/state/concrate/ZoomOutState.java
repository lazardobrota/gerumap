package raf.dsw.gerumap.gui.swing.state.concrate;

import raf.dsw.gerumap.gui.swing.state.State;
import raf.dsw.gerumap.gui.swing.view.MindMapView;

public class ZoomOutState extends State {
    @Override
    public void pressed(int x, int y, MindMapView m) {
        m.setZoom(m.getZoom() * 0.8);
        m.repaint();
        System.out.println("ZoomOut");
    }
}
