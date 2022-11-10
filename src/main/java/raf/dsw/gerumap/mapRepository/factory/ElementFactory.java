package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Element;

public class ElementFactory extends NodeFactory{

    @Override
    public MapNode createNode() {
        return new Element();
    }
}
