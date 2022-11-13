package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
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
        if (MainFrame.getInstance().getMapTree().getSelectedNode() == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.NOTHING_IS_SELECTED);
            return;
        }
        if (!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.CANNOT_SET_AUTHOR);
            return;
        }
        Project project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        EditFrame.getInstance().getTfNazivAutora().setText(project.getAutor()); //Napise prethodni naziv autora u textBox
        EditFrame.getInstance().setVisible(true);
    }
}
