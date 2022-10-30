package raf.dsw.gerumap.mapRepository.composite;

public abstract class MapNode {
    //MapNode su svi elemeti: Project Explorer(on jedini nema roditelja), Projekat, mapa uma i pojmovi

    private String ime;
    private MapNode parent;//svaki mapNode ima svog roditelja

    public MapNode(String ime, MapNode parent) {
        this.ime = ime;
        this.parent = parent;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public MapNode getParent() {
        return parent;
    }

    public void setParent(MapNode parent) {
        this.parent = parent;
    }
}
