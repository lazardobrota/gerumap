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
        projectChanged();
        this.notifySubs(this);
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
        projectChanged();
        this.notifySubs(this);
    }

    public void projectChanged() {
        if (this.getParent() == null)//Mora da ima roditelja da bi mogla promena da se izvrsi
            return;
        Project project = (Project) this.getParent().getParent();
        project.setChanged(true);
    }
}
