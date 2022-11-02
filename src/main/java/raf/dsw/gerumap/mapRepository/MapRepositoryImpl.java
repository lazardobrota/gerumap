package raf.dsw.gerumap.mapRepository;

import raf.dsw.gerumap.core.MapRepository;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public class MapRepositoryImpl implements MapRepository {

    private ProjectExplorer projectExplorer;

    public MapRepositoryImpl() {
        this.projectExplorer = new ProjectExplorer("My Project Explorer");
    }

    @Override
    public boolean addChild(MapNodeComposite parent, MapNode child) {
        return false;
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

}
