package raf.dsw.gerumap.mapRepository.composite;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.observer.Publisher;
import raf.dsw.gerumap.gui.swing.observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
/**
 * MapNode su svi elemeti: Project Explorer(on jedini nema roditelja), Projekat, mapa uma i pojmovi
 */
public abstract class MapNode implements Publisher {

    private String ime;
    private MapNode parent;//svaki mapNode ima svog roditelja

    private List<Subscriber> subscribers;

    public MapNode(String ime, MapNode parent) {
        this.ime = ime;
        this.parent = parent;

        subscribers = new ArrayList<>();
    }
    public MapNode(){

    }

    public void setIme(String ime) {
        this.ime = ime;
        this.notifySubs(this);
    }

    //Da li su ista imena
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MapNode))
            return false;

        MapNode mapNode = (MapNode) obj;
        return this.getIme().equals(mapNode.getIme());
    }

    @Override
    public String toString() {
        return this.ime;
    }

    //TODO: Mapa uma nema subs pa nikada ne ulazi u promenu imena
    @Override
    public void notifySubs(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;


        for(Subscriber listener : subscribers){
            listener.update(notification);
        }
    }

    @Override
    public void addSubs(Subscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubs(Subscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }



}
