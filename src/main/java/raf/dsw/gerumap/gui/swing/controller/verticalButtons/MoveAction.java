package raf.dsw.gerumap.gui.swing.controller.verticalButtons;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MoveAction extends AbstractGerumapAction {

    public MoveAction() {
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,loadIcon("/images/autor.png"));
        putValue(NAME,"Move");
        putValue(SHORT_DESCRIPTION,"Pomeranje elementa po platnu");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
