package raf.dsw.gerumap.gui.swing.state;

import raf.dsw.gerumap.gui.swing.view.MindMapView;

public abstract class State {

    public abstract void pressed(int x, int y, MindMapView m);
    public  void released(int x, int y, MindMapView m) {
    }
    public  void dragged(int x, int y, MindMapView m) {
    }
}
