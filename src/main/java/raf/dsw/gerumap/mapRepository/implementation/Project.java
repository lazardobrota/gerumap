package raf.dsw.gerumap.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;

@Getter
@Setter
public class Project extends MapNodeComposite {

    private String autor = "";   //osoba koja je napravila projekat
    protected String filePath;
    protected boolean changed = true;

    public Project(String ime, MapNode parent, String autor, String filePath) {
        super(ime, parent);
        this.autor = autor;
        this.filePath = filePath;
    }
    public Project(String ime, MapNode parent){
        super(ime,parent);
    }
    public Project(){
        this.setStartingName("Projekat");
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
        mapNode.setParent(this);
        this.notifySubs(this);//prosledjujemo ovaj minMap jer treba od njega novi tab da se napravi i treba da obavesti njegove subove da se apdejtaju
        return true;
    }

    @Override
    public String toString() {
        return "Projekat: " + getIme() + ", Autor: " + getAutor();
    }

    public void setAutor(String autor) {
        this.autor = autor;
        this.notifySubs(this);
        this.changed = true;
    }

    @Override
    public void setIme(String ime) {
        super.setIme(ime);
        this.changed = true;
    }
}
