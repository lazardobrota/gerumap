package raf.dsw.gerumap.gui.swing.tree.view;

import raf.dsw.gerumap.gui.swing.tree.controller.MapTreeCellEditor;
import raf.dsw.gerumap.gui.swing.tree.controller.MapTreeSelectionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MapTreeView extends JTree {

    public MapTreeView(DefaultTreeModel defaultTreeModel) {
        this.setModel(defaultTreeModel);//ovo je cvor i modeli koji se prikazuju
        MapTreeCellRenderer mapTreeCellRenderer = new MapTreeCellRenderer();
        this.addTreeSelectionListener(new MapTreeSelectionListener());
        this.setCellEditor(new MapTreeCellEditor(this, mapTreeCellRenderer));
        this.setCellRenderer(mapTreeCellRenderer);
        this.setEditable(true);
    }
}
