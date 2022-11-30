package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.mapRepository.composite.MapNode;

import java.awt.*;

public abstract class Element extends MapNode {//todo treba da bude abstract i da se promeni Factory za element

    private Color color;
    private int stroke;//debljina linije

    public Element(String ime, MapNode parent) {
        super(ime, parent);
    }
    public Element(){
        this.setStartingName("Element");
    }


}
