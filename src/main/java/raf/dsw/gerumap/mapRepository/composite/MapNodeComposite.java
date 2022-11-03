package raf.dsw.gerumap.mapRepository.composite;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
/**
 * On je element koji moze da ima grupe drugih elemenata u sebi
 */
public abstract class MapNodeComposite extends MapNode{

    //kompozicija gde je OVO onaj crni romb a strelica je kod MapNode
    private List<MapNode> children;

    public MapNodeComposite(String ime, MapNode parent) {
        super(ime, parent);
        children = new ArrayList<>();
    }

    //Mozda ako ucitavamo vec postojaci projekat pa da mozemo odmah sve mape uma da dodamo??????
    public MapNodeComposite(String ime, MapNode parent, List<MapNode> children) {
        super(ime, parent);
        this.children = children;
    }

    public abstract boolean addChild(MapNode mapNode);

    public void deleteChild(MapNode mapNode) {
        children.remove(mapNode);
    }
}
