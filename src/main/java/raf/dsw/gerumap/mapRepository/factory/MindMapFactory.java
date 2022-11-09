package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

public class MindMapFactory extends NodeFactory{

    @Override
    public MapNode createNode() {
        return new MindMap(" ",null,false);
    }

}
