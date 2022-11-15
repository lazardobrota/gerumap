package raf.dsw.gerumap.gui.swing.tree.controller;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
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
            if (((MouseEvent) event).getClickCount() == 3)
                return  true;
            else if (((MouseEvent) event).getClickCount() == 2) {
                MapTreeItem clicked = MainFrame.getInstance().getMapTree().getSelectedNode();
                if (clicked.getMapNode() != null && clicked.getMapNode() instanceof Project) {
                    Project project = (Project) clicked.getMapNode();
                    MainFrame.getInstance().getProjectView().setProject(project);
                }
            }
        }
        return false;
    }

    public boolean isCellNameUnique(MapNodeComposite parent, ActionEvent e) {

        if (!e.getActionCommand().matches("[a-zA-Z 0-9]+")) { //Ne moze da bude prazno ime
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.INVALID_NAME);
            return false;
        }
        if (parent == null)//roditelj ProjectExplorer-a ne postoji
            return true;

        for (MapNode child : parent.getChildren()) {
            if (child.getIme().equals(e.getActionCommand()))
                return false;
        }

        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.clickedOn instanceof MapTreeItem) {
            MapTreeItem clicked = (MapTreeItem) this.clickedOn;

            if (isCellNameUnique((MapNodeComposite) clicked.getMapNode().getParent(), e))
                clicked.setName(e.getActionCommand());//ono sto se ukuca u aplikaciji ide ovde kao e.getActionCommand(), string je
        }
    }
}
