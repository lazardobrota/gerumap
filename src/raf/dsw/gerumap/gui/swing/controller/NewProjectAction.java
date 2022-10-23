package raf.dsw.gerumap.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class NewProjectAction extends AbstractGerumapAction{

    public NewProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));//ACCELERATOR_KEY - zadajemo precicu
        putValue(SMALL_ICON, loadIcon("images/plus.png"));//jos uvek nemam nista u images paketu ali dodaje ikonicu za New Project, verovatno u MenuBar ako tamo napravimo instancu klase
        putValue(NAME, "New Project");//Zvace se New Project
        putValue(SHORT_DESCRIPTION, "Napravi novi projekat");//Ono sto ce pisati ako drzimo mis duze na ikonicu kao objasnjenje sta radi
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n = new Random().nextInt(180);
    }
}
