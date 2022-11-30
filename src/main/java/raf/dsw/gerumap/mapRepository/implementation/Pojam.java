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

    public Pojam(Dimension dimension, Point position) {
        this.dimension = dimension;
        this.position = position;
    }
}
