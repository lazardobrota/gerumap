package raf.dsw.gerumap.mapRepository.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class MapNodeComposite extends MapNode{
    //On je element koji moze da ima grupe drugih elemenata u sebi

    //kompozicija gde je OVO onaj crni romb a strelica je kod MapNode
    private List<MapNode> mapNodes;//todo: Ne znam koji paket da implementiram za listu

    public MapNodeComposite(String ime, MapNode parent) {
        super(ime, parent);
        mapNodes = new ArrayList<>();
    }

    public boolean addChild(MapNode mapNode) {

        for (MapNode mn : mapNodes) {
            if (mn.getIme().equals(mapNode.getIme()))
                return false;
        }

        mapNodes.add(mapNode);
        return true;
    }
    //todo: deleteChild() nije verovatno dobar
    public void deleteChild(MapNode mapNode) {
        mapNodes.remove(mapNode);
    }

    public List<MapNode> getMapNodes() {
        return mapNodes;
    }

    public void setMapNodes(List<MapNode> mapNodes) {
        this.mapNodes = mapNodes;
    }
}
