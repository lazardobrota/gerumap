package raf.dsw.gerumap.gui.swing.tree;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public interface MapTree {

    //na pokretanje napravi prazan prvi cvor
    MapTreeView generateTree(ProjectExplorer projectExplorer);
    //na parenta dodaje dete
    void addChild(MapTreeItem parent);
    void deleteChild(MapTreeItem child);
    MapTreeItem getSelectedNode();
    MapTreeView getTreeView();
    void loadProject(Project project);
    void loadMindMap(MindMap mindMap);
    void loadSablon(MindMap sablon, MindMap mindMap);
}
