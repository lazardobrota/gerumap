package raf.dsw.gerumap.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;

import java.awt.*;

@Getter
@Setter
public abstract class Element extends MapNode {

    private int color;
    private int stroke = 1;//debljina linije
    private double zoom = 1;

    public Element(String ime, MapNode parent) {
        super(ime, parent);
    }
    public Element(){
        this.setStartingName("Element");
    }

    public void setColor(int color) {
        this.color = color;
        this.notifySubs(this);
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
        this.notifySubs(this);
    }

}
