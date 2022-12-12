package raf.dsw.gerumap.gui.swing.state.concrate;

import raf.dsw.gerumap.gui.swing.state.State;
import raf.dsw.gerumap.gui.swing.view.MindMapView;

public class ZoomOutState extends State {
    @Override
    public void pressed(int x, int y, MindMapView m) {

        //Ne moze vise od ovoga da odzumira
        if (m.getZoom() < 0.2)
            return;

        m.setZoom(m.getZoom() - 0.2);
        m.repaint();
        System.out.println("ZoomOut");
    }
}
