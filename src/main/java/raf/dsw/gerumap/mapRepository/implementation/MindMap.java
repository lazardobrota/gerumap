package raf.dsw.gerumap.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.mapRepository.commands.CommandManager;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;

@Getter
@Setter
public class MindMap extends MapNodeComposite {

    private boolean sablon;
    private transient CommandManager commandManager;

    public MindMap(String ime, MapNode parent, boolean sablon) {
        super(ime, parent);
        this.sablon = sablon;
    }
    public MindMap(){
        this.setStartingName("MindMap");
        sablon = false;
        commandManager = new CommandManager();
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
        System.out.println(this.getChildren().size());
        element.setParent(this);
        Project project = (Project) this.getParent();
        project.setChanged(true);//Doslo je do promene
        this.notifySubs(this);
        return true;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
}
