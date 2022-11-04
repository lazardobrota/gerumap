package raf.dsw.gerumap.gui.swing.tree;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeModel;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

import javax.swing.*;

public class MapTreeImplementation implements MapTree{

    private MapTreeView mapTreeView;
    private MapTreeModel treeModel;

    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new MapTreeModel(root);//Cvor koji se postavlja kao glavni(root) od cega sve sve racva i ovde je to projectExplorer
        mapTreeView = new MapTreeView(treeModel);//Povezuje sve klase u jednu

        return mapTreeView;
    }

    private MapNode createChild(MapNode parent){
        if(parent instanceof ProjectExplorer){
            return new Project("Project", parent);
        }
        else if (parent instanceof Project) {
            return new MindMap("MindMap", parent, false);
        }
        else {
            return new Element("Element", parent);
        }
    }

    @Override
    public void addChild(MapTreeItem parent) {
        if(parent.getMapNode() instanceof MapNodeComposite){
            MapNode child = this.createChild(parent.getMapNode());
            //proverava jel to project explorer npr i dodaje dete
            parent.add(new MapTreeItem(child));//ovde dodaje novu decu i to vidimo
            mapTreeView.expandPath(mapTreeView.getSelectionPath());//i osvezavamo
            SwingUtilities.updateComponentTreeUI(mapTreeView);
        }
    }

    @Override
    public MapTreeItem getSelectedNode(){
        return (MapTreeItem) mapTreeView.getLastSelectedPathComponent();
    }
}
