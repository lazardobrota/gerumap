package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Project;

public class ProjectFactory extends NodeFactory{

    @Override
    public MapNode createNode() {
        return new Project(" ",null);
    }
}
