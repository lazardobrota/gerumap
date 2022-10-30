package raf.dsw.gerumap.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditAction extends AbstractGerumapAction{

    public EditAction(){

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,loadIcon("images/edit.png"));
        putValue(NAME,"Edit");
        putValue(SHORT_DESCRIPTION,"Izmeni");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
