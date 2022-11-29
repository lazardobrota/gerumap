package raf.dsw.gerumap.gui.swing.controller.verticalButtons;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddElementAction extends AbstractGerumapAction {

    public AddElementAction() {
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK)); VEC IMA SA OVIM
        putValue(SMALL_ICON,loadIcon("/images/pojam.png"));
        putValue(NAME,"DodajElement");
        putValue(SHORT_DESCRIPTION,"Dodaj novi element(Pojam) na platno");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startAddElementState();
    }
}
