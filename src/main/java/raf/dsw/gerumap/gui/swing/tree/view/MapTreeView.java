package raf.dsw.gerumap.gui.swing.tree.view;

import raf.dsw.gerumap.gui.swing.tree.controller.MapTreeCellEditor;
import raf.dsw.gerumap.gui.swing.tree.controller.MapTreeSelectionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

/**
 * Ovde se sve klase medjusobno povezuju i prikazuju na aplikaciju
 */
public class MapTreeView extends JTree {

    public MapTreeView(DefaultTreeModel defaultTreeModel) {
        this.setModel(defaultTreeModel);//gleda koje je ime cvora da ga postavi, toString() metoda
        MapTreeCellRenderer mapTreeCellRenderer = new MapTreeCellRenderer();//za slike
        this.addTreeSelectionListener(new MapTreeSelectionListener());//Posmatra da li ima promene na tree
        this.setCellEditor(new MapTreeCellEditor(this, mapTreeCellRenderer));//Klasa koja ce da edituje cvorove(menjanje imena, ...)
        this.setCellRenderer(mapTreeCellRenderer);
        this.setEditable(true);//tree nije readOnly nego moze da se edituje(menjaju imena cvorova, dodaju novi cvorovi, ...)
    }
}
