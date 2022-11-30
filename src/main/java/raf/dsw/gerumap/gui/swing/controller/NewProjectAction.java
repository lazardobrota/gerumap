package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.factory.NodeFactory;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewProjectAction extends AbstractGerumapAction{

    private NodeFactory nodeFactory;

    public NewProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));//ACCELERATOR_KEY - zadajemo precicu
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));//jos uvek nemam nista u images paketu ali dodaje ikonicu za New Project, verovatno u MenuBar ako tamo napravimo instancu klase
        putValue(NAME, "New Project");//Zvace se New Project
        putValue(SHORT_DESCRIPTION, "Napravi novi projekat");//Ono sto ce pisati ako drzimo mis duze na ikonicu kao objasnjenje sta radi
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Bira cvor koji smo selektovali
        MapTreeItem selektovan = MainFrame.getInstance().getMapTree().getSelectedNode(); //getSelectedNode() vraca MapTreeItem pa ne treba cast

        //Ne moze da doda mapi uma dodate element na newProjectAction
        if (selektovan.getMapNode() instanceof MindMap) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.CANNOT_ADD_CHILD);
            return ;
        }

        MainFrame.getInstance().getMapTree().addChild(selektovan);

    }
}
