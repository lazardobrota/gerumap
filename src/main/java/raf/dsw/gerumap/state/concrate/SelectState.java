package raf.dsw.gerumap.state.concrate;

import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.state.State;

public class SelectState extends State {

    @Override
    public void pressed(int x, int y, MindMapView m) {
        System.out.println("Selected");
    }
}
