package raf.dsw.gerumap.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;

@Getter
@Setter
public class Project extends MapNodeComposite {

    private String autor = " ";   //osoba koja je napravila projekat
    private String putanja;

    public Project(String ime, MapNode parent, String autor, String putanja) {
        super(ime, parent);
        this.autor = autor;
        this.putanja = putanja;
    }
    public Project(String ime, MapNode parent){
        super(ime,parent);
    }
    public Project(){

    }

    //Dodaje mapu uma u Project
    @Override
    public boolean addChild(MapNode mapNode) {
        if (mapNode == null || !(mapNode instanceof MindMap))
            return false;

        MindMap mindMap = (MindMap) mapNode;
        if (this.getChildren().contains(mindMap))
            return false;

        this.getChildren().add(mindMap);
        return true;
    }

    @Override
    public String toString() {
        return "Projekat: " + getIme() + ", Autor: " + getAutor();
    }
}
