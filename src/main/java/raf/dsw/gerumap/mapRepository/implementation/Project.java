package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;

public class Project extends MapNodeComposite {

    private String autor;   //osoba koja je napravila projekat
    private String putanja;

    public Project(String ime, MapNode parent) {
        super(ime, parent);
    }
}
