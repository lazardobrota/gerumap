package raf.dsw.gerumap.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;

@Getter
@Setter
public class MindMap extends MapNodeComposite {

    private boolean sablon;

    public MindMap(String ime, MapNode parent, boolean sablon) {
        super(ime, parent);
        this.sablon = sablon;
    }
    public MindMap(){
        this.setStartingName("MindMap");
        sablon = false;
    }

    @Override
    public void setIme(String ime) {
        super.setIme(ime);
        Project parent = (Project) this.getParent();//Salje roditelja mape uma koja je promenjena
        parent.notifySubs(parent);
    }

    //Dodaje element u MindMap
    @Override
    public boolean addChild(MapNode mapNode) {
        if (mapNode == null || !(mapNode instanceof Element))
            return false;

        Element element = (Element) mapNode;
        if (this.getChildren().contains(element))
            return false;

        this.getChildren().add(element);
        return true;
    }

}
