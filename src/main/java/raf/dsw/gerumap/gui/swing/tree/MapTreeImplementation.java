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

    private MapNode createChild(MapNodeComposite parent){

        MapNode child;

        if(parent instanceof ProjectExplorer){
            child = new Project("Project" + parent.getChildren().size(), parent);
            if (!parent.getChildren().contains(child)) {
                parent.addChild(child);
                return child;
            }
        }
        else if (parent instanceof Project) {
            child = new MindMap("MindMap" + parent.getChildren().size(), parent, false);
            if (!parent.getChildren().contains(child)) {
                parent.addChild(child);
                return child;
            }
        }
        else if (parent instanceof MindMap) {
            child = new Element("Element" + parent.getChildren().size(), parent);
            if (!parent.getChildren().contains(child)) {
                parent.addChild(child);
                return child;
            }
        }

        return null;
    }

    @Override
    public void addChild(MapTreeItem parent) {
        if(parent.getMapNode() instanceof MapNodeComposite){
            //Da bi mogli da koristimo addChild() metodu koja sama proverava ako ima decu sa istim imenima
            MapNodeComposite p = (MapNodeComposite) parent.getMapNode();
            MapNode child = this.createChild(p);
            //child je null kada vec postoji MapNode sa tim imenom kod tog parenta
            if (child == null)
                return;
            
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
