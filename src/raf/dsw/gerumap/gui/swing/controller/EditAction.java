package raf.dsw.gerumap.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class EditAction extends AbstractGerumapAction{

    public EditAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(InputEvent.SHIFT_DOWN_MASK, KeyEvent.VK_I));
        putValue(SMALL_ICON, loadIcon("images/x.png"));// dodaj u images sliku pa promenu lokaciju do slike koja treba da bude
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Informacije");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
