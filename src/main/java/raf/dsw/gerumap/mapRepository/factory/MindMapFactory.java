package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

public class MindMapFactory extends NodeFactory{

    public MindMapFactory(String ime, MapNode parent) {
        super(ime, parent);
    }

    @Override
    public MapNode createNode() {
        return new MindMap(getIme(),getParent(),false);
    }

}
