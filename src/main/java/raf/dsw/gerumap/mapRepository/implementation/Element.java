package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.mapRepository.composite.MapNode;

public class Element extends MapNode {

    public Element(String ime, MapNode parent) {
        super(ime, parent);
    }
    public Element(){
        this.setIme("Element" + ((MindMap)this.getParent()).getNumberingChildren());
    }


}
