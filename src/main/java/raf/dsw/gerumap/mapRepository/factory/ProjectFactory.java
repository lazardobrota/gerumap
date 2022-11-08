package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Project;

public class ProjectFactory extends NodeFactory{

    public ProjectFactory(String ime, MapNode parent) {
        super(ime, parent);
    }

    @Override
    public MapNode createNode() {
        return new Project(getIme(),getParent());
    }
}
