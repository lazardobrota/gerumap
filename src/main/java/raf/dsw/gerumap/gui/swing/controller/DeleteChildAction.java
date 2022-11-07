package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteChildAction extends AbstractGerumapAction{

    public DeleteChildAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,loadIcon("/images/delete.png"));
        putValue(NAME,"Delete");
        putValue(SHORT_DESCRIPTION,"Izbrisi dete u stablu");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getMapTree().deleteChild(MainFrame.getInstance().getMapTree().getSelectedNode());
    }
}
