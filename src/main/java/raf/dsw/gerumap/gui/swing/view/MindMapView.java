package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.observer.Subscriber;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

import javax.swing.*;

public class MindMapView extends JPanel implements Subscriber {

    private MindMap mindMap;

    public MindMapView() {
    }

    @Override
    public void update(Object notification) {

    }
}
