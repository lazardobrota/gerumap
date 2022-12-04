package raf.dsw.gerumap.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;

import java.awt.*;

@Getter
@Setter
public abstract class Element extends MapNode {

    private Color color;
    private int stroke = 1;//debljina linije

    public Element(String ime, MapNode parent) {
        super(ime, parent);
    }
    public Element(){
        this.setStartingName("Element");
    }

    //todo povezi element sa subovima
    public void setColor(Color color) {
        this.color = color;
        this.notifySubs(this);
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
        this.notifySubs(this);
    }
}
