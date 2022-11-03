package raf.dsw.gerumap.gui.swing.tree.controller;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class  MapTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object clickedOn = null;//Objekat na koji se kliknulo

    private JTextField edit = null;// kada se klikne par puta treba on da se otvor(zamenski objekat)

    public MapTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
        clickedOn = value;
        edit = new JTextField(value.toString());
        edit.addActionListener(this);

        return edit;
    }

    @Override
    public boolean isCellEditable(EventObject event) {
        if (event instanceof MouseEvent) {
            return ((MouseEvent) event).getClickCount() == 3;
        }

        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.clickedOn instanceof MapTreeItem) {
            MapTreeItem clicked = (MapTreeItem) this.clickedOn;
            clicked.setName(e.getActionCommand());//ono sto se ukuca u aplikaciji ide ovde kao e.getActionCommand()
        }
    }
}
