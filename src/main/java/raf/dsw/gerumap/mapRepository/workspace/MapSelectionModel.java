package raf.dsw.gerumap.mapRepository.workspace;

import raf.dsw.gerumap.gui.swing.observer.Publisher;
import raf.dsw.gerumap.gui.swing.observer.Subscriber;
import raf.dsw.gerumap.mapRepository.implementation.Element;

import java.util.ArrayList;
import java.util.List;

public class MapSelectionModel implements Publisher {

    List<Element> selectedElements = new ArrayList<>();

    public MapSelectionModel() {
    }

    @Override
    public void notifySubs(Object notification) {

    }

    @Override
    public void addSubs(Subscriber sub) {

    }

    @Override
    public void removeSubs(Subscriber sub) {

    }
}
