package raf.dsw.gerumap.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;

@Getter
@Setter
public class Veza extends Element{

    private Pojam from;
    private Pojam to;

    public Veza(String ime, MapNode parent, Pojam from, Pojam to) {
        super(ime, parent);
        this.from = from;
        this.to = to;
    }

    public Veza(Pojam from, Pojam to) {
        this.from = from;
        this.to = to;
    }
}
