package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public class ProjectExplorerFactory extends NodeFactory{

    public ProjectExplorerFactory(String ime, MapNode parent) {
        super(ime, parent);
    }

    @Override
    public MapNode createNode() {
        return new ProjectExplorer(getIme());
    }
}
