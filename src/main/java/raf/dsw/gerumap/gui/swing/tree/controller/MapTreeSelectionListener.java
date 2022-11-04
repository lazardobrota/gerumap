package raf.dsw.gerumap.gui.swing.tree.controller;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.util.Arrays;

public class MapTreeSelectionListener implements TreeSelectionListener {
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();//putanja do selektovanog cvora
        MapTreeItem itemSelected = (MapTreeItem) path.getLastPathComponent(); // uzima cvor koji je selektovan
        System.out.println("Selektovan cvor: " + itemSelected.getMapNode().getIme());
        System.out.println("getPath: " + Arrays.toString(path.getPath()));
    }
}
