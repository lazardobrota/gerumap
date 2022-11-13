package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.EditFrame;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.ProjectView;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveAction implements ActionListener {

    private MapNode projekat;

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selektovan = MainFrame.getInstance().getMapTree().getSelectedNode();
        projekat = selektovan.getMapNode();

        if(selektovan != null && projekat instanceof Project){
            ((Project) projekat).setAutor(EditFrame.getInstance().getTfNazivAutora().getText());
            EditFrame.getInstance().getTfNazivAutora().setText("");
        }
        EditFrame.getInstance().dispose();
    }
}
