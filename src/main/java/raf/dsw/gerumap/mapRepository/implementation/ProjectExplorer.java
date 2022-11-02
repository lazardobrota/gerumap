package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;

public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String ime) {
        super(ime, null);
    }

    //Dodaje projekat u ProjectExplorer
    @Override
    public boolean addChild(MapNode mapNode) {
        if (mapNode == null || !(mapNode instanceof Project))
            return false;

        Project p = (Project) mapNode;
        if (this.getChildren().contains(p))
            return false;

        this.getChildren().add(p);
        return true;
    }

    @Override
    public void deleteChild(MapNode mapNode) {
        super.deleteChild(mapNode);
    }
}
