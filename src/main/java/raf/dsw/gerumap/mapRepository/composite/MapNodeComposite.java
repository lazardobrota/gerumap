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
    private List<MapNode> children = new ArrayList<>();
    private int numberingChildren = 1;

    public MapNodeComposite(String ime, MapNode parent) {
        super(ime, parent);
    }
    public MapNodeComposite(){

    }

    public abstract boolean addChild(MapNode mapNode);

    public void deleteChild(MapNode mapNode) {
        children.remove(mapNode);
    }

    public int getNumberingChildren() {
        return numberingChildren++;
    }
}
