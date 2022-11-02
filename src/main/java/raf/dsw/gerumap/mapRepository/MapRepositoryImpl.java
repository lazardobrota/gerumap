package raf.dsw.gerumap.mapRepository;

import raf.dsw.gerumap.core.MapRepository;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

/**
 * Ovde pravimo projectExplorer koji ce se kasnije postavljati dok tree
 */
public class MapRepositoryImpl implements MapRepository {

    private ProjectExplorer projectExplorer;

    public MapRepositoryImpl() {
        this.projectExplorer = new ProjectExplorer("My Project Explorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

}
