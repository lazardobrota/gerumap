package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public class FactoryUtils {

    public static NodeFactory getFactory(MapNode mapNode) {

        if (mapNode instanceof ProjectExplorer) {
            return new ProjectFactory();
        }
        else if(mapNode instanceof Project){
            return new MindMapFactory();
        }
        else if(mapNode instanceof MindMap){
            return new ElementFactory();
        }
        else {
            return null;
        }
    }
}
