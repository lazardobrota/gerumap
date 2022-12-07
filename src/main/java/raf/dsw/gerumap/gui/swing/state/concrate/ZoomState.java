package raf.dsw.gerumap.gui.swing.state.concrate;

import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.gui.swing.state.State;

public class ZoomState extends State {

    @Override
    public void pressed(int x, int y, MindMapView m) {

        m.setZoom(m.getZoom() * 1.2);
        m.repaint();
        System.out.println("Zoom");
    }
}
