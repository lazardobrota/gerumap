package raf.dsw.gerumap.state;

import raf.dsw.gerumap.gui.swing.view.MindMapView;

public abstract class State {

    public abstract void pressed(int x, int y, MindMapView m);
}
