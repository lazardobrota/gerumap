package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.EditFrame;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AutorAction extends AbstractGerumapAction{



    public AutorAction(){

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,loadIcon("/images/autor.png"));
        putValue(NAME,"Autor");
        putValue(SHORT_DESCRIPTION,"Promeni autora");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getMapTree().getSelectedNode() == null)
            return;
        if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)
        EditFrame.getInstance().setVisible(true);
    }
}
