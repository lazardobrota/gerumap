package raf.dsw.gerumap.state;

import raf.dsw.gerumap.gui.swing.view.MindMapView;

import java.awt.*;

public abstract class State {

    public abstract void pressed(int x, int y, MindMapView m);
    public  void released(int x, int y, MindMapView m) {
    }
    public  void dragged(int x, int y, MindMapView m) {
    }
}
