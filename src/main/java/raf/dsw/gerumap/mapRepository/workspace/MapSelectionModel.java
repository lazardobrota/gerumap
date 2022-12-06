package raf.dsw.gerumap.mapRepository.workspace;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.observer.Publisher;
import raf.dsw.gerumap.gui.swing.observer.Subscriber;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MapSelectionModel implements Publisher {

    Pojam fakePojam;
    List<Element> selectedElements = new ArrayList<>();
    private List<Subscriber> subscribers = new ArrayList<>();

    public MapSelectionModel() {

    }

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

    public void setFakePojam(Pojam fakePojam) {
        this.fakePojam = fakePojam;
        this.notifySubs(this);
    }
}
