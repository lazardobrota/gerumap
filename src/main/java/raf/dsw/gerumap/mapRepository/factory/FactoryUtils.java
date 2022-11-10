package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public class FactoryUtils {

    private static final ProjectFactory projectFactory = new ProjectFactory();
    private static final MindMapFactory mindMapFactory = new MindMapFactory();
    private static final ElementFactory elementFactory = new ElementFactory();

    //Ovo su svi moguci MapNodeComposite
    public static NodeFactory getFactory(MapNode mapNode) {

        if (mapNode instanceof ProjectExplorer) {
            return projectFactory;
        }

        if (mapNode instanceof Project){
            return mindMapFactory;
        }

        if (mapNode instanceof MindMap){
            return elementFactory;
        }

        return null;
    }
}
