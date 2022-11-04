package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewProjectAction extends AbstractGerumapAction{

    public NewProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));//ACCELERATOR_KEY - zadajemo precicu
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));//jos uvek nemam nista u images paketu ali dodaje ikonicu za New Project, verovatno u MenuBar ako tamo napravimo instancu klase
        putValue(NAME, "New Project");//Zvace se New Project
        putValue(SHORT_DESCRIPTION, "Napravi novi projekat");//Ono sto ce pisati ako drzimo mis duze na ikonicu kao objasnjenje sta radi
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Ako nista nije selektovano da nema crash
        if (MainFrame.getInstance().getMapTree().getSelectedNode() == null)
            return;
        //Bira cvor koji smo selektovali
        MapTreeItem selektovan = MainFrame.getInstance().getMapTree().getSelectedNode(); //getSelectedNode() vraca MapTreeItem pa ne treba cast
        MainFrame.getInstance().getMapTree().addChild(selektovan);
    }
}
