package raf.dsw.gerumap.gui.swing.controller;

import javax.swing.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ExitAction extends AbstractGerumapAction{

    public ExitAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/x.png"));// dodaj u images sliku pa promenu lokaciju do slike koja treba da bude
        putValue(NAME, "Exit");
        putValue(SHORT_DESCRIPTION, "Izlaz iz aplikacije");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
