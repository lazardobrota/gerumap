package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.mapRepository.composite.MapNode;

import java.awt.*;

public abstract class Element extends MapNode {

    private Color color;
    private int stroke;//debljina linije

    public Element(String ime, MapNode parent) {
        super(ime, parent);
    }
    public Element(){
        this.setStartingName("Element");
    }


}
