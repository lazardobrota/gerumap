package raf.dsw.gerumap.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;

import java.awt.*;

@Getter
@Setter
public class Pojam extends Element{

    private Dimension dimension;
    private Point position;

    public Pojam(String ime, MapNode parent, Dimension dimension, Point position) {
        super(ime, parent);
        this.dimension = dimension;
        this.position = position;
    }

    //Koristi se za proveru da li postoji takav pojam
    public Pojam(Dimension dimension, Point position) {
        this.dimension = dimension;
        this.position = position;
    }

    //Kada se ucitava sablon
    public Pojam() {
    }

    public void sablonPojam(Pojam pojam) {
        this.setIme(pojam.getIme());
        this.setDimension(pojam.getDimension());
        this.setPosition(pojam.getPosition());
        this.setStroke(pojam.getStroke());
        this.setColor(pojam.getColor());
    }

    public void setPosition(Point position) {
        this.position = position;
        projectChanged();
        this.notifySubs(this);
    }
}
