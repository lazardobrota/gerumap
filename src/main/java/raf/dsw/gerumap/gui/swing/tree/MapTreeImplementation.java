package raf.dsw.gerumap.gui.swing.tree;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeModel;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MainPanel;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.factory.FactoryUtils;
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

        MapNode child = FactoryUtils.getFactory(parent).getNode();
        parent.addChild(child);
        return child;
    }

    @Override
    public void addChild(MapTreeItem parent) {

        //Da li mozemo da dodamo dete
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
        else {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.CANNOT_ADD_CHILD);
        }
    }

    @Override
    public void deleteChild(MapTreeItem child) {
        if (child == null) { //Ako nista nije selektovano
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.EXCEPTION, ProblemType.NOTHING_IS_SELECTED);
            return;
        }

        MapNodeComposite parent = (MapNodeComposite) child.getMapNode().getParent();
        if (parent == null) { //Ne mozemo projectExplorer da brisemo
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.CANNOT_REMOVE_PROJECT_EXPLORER);
            return;
        }

        parent.deleteChild(child.getMapNode());
        treeModel.removeNodeFromParent(child);
    }
    @Override
    public void loadProject(Project node) {
        //ucitavamo vec sacuvan projekat u aplikaciju
        MapTreeItem loadedProject = new MapTreeItem(node);
        treeModel.getRoot().add(loadedProject);

        MapNodeComposite mapNode = (MapNodeComposite) treeModel.getRoot().getMapNode();
        int numChildren = mapNode.getChildren().size();//Koliko dece ima
        mapNode.addChild(node);
        String name = node.getIme();
        while (numChildren == mapNode.getChildren().size()) {//Nije mu dodao dete jer vec takvo postoji pa mu menja ime
            node.setIme(name + mapNode.getNumberingChildren());
            mapNode.addChild(node);
        }


        for (MapNode mindMap : node.getChildren()) {
            mindMap.setParent(node);//Uvek je na pocetku roditelj null pa mora ponovo da se doda
            loadMindMap((MindMap) mindMap);
        }

        mapTreeView.expandPath(mapTreeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(mapTreeView);
    }

    @Override
    public void loadMindMap(MindMap mindMap) {
        MapNodeComposite projectExplorer = (MapNodeComposite) treeModel.getRoot().getMapNode();
        MapTreeItem mapTreeItemProject = null;
        int i = 0;
        for (MapNode mapNode : projectExplorer.getChildren()) {
            if (mapNode.equals(mindMap.getParent())) {//Ako roditelj mindMape koju upisujemo ima istog parenta kao neko dete projectExplorera onda smo nasli taj projekat
                mapTreeItemProject = (MapTreeItem) treeModel.getRoot().getChildAt(i);
                break;
            }
            i++;
        }

        if (mapTreeItemProject == null)
            return;

        MapTreeItem loadedMindMap = new MapTreeItem(mindMap);//pravi TreeItem od mindmape
        mapTreeItemProject.add(loadedMindMap);//Dodaje ga Projetku kao TreeItem

        mapTreeView.expandPath(mapTreeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(mapTreeView);
    }

    @Override
    public MapTreeItem getSelectedNode(){
        return (MapTreeItem) mapTreeView.getLastSelectedPathComponent();
    }

    @Override
    public MapTreeView getTreeView() {
        return mapTreeView;
    }

}
