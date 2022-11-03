package raf.dsw.gerumap.mapRepository.composite;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * MapNode su svi elemeti: Project Explorer(on jedini nema roditelja), Projekat, mapa uma i pojmovi
 */
public abstract class MapNode {

    private String ime;
    private MapNode parent;//svaki mapNode ima svog roditelja

    public MapNode(String ime, MapNode parent) {
        this.ime = ime;
        this.parent = parent;
    }

    //Da li su ista imena
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MapNode))
            return false;

        MapNode mapNode = (MapNode) obj;
        return this.getIme().equals(mapNode.getIme());
    }

    @Override
    public String toString() {
        return this.ime;
    }
}
