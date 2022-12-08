package raf.dsw.gerumap.gui.swing.state.concrate;

import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.gui.swing.state.State;

public class ZoomInState extends State {

    @Override
    public void pressed(int x, int y, MindMapView m) {

        //Ne moze vise od ovoga da zumira
        if (m.getZoom() > 2)
            return;

        m.setZoom(m.getZoom() * 1.2);
        m.repaint();
        System.out.println("Zoom");
    }
}
