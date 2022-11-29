package raf.dsw.gerumap.gui.swing.controller.verticalButtons;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ConnectAction extends AbstractGerumapAction {

    public ConnectAction() {
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,loadIcon("/images/autor.png"));
        putValue(NAME,"Connect");
        putValue(SHORT_DESCRIPTION,"Povezuje dva elementa");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
