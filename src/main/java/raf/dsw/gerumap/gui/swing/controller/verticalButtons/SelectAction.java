package raf.dsw.gerumap.gui.swing.controller.verticalButtons;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SelectAction extends AbstractGerumapAction {

    public SelectAction() {
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,loadIcon("/images/autor.png"));
        putValue(NAME,"Select");
        putValue(SHORT_DESCRIPTION,"Seleketovanje pojmova ili veza");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
