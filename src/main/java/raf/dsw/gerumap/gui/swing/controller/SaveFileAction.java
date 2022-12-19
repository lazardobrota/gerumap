package raf.dsw.gerumap.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SaveFileAction extends AbstractGerumapAction {

    public SaveFileAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/save.png"));
        putValue(NAME, "Save action");
        putValue(SHORT_DESCRIPTION, "Save action");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
