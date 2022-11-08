package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public class FactoryUtils {

    public static MapNode getFactory(MapNode mapNode) {
        if (mapNode instanceof ProjectExplorer) {
            return null;
        }else if(mapNode instanceof Project){
            return null;
        }else if(mapNode instanceof MindMap){
            return null;
        }else{
            return null;
        }
    }
}
