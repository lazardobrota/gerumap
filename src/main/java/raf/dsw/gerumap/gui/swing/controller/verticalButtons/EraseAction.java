package raf.dsw.gerumap.gui.swing.controller.verticalButtons;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class EraseAction extends AbstractGerumapAction {

    public EraseAction() {
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,loadIcon("/images/erase.png"));
        putValue(NAME,"Erase");
        putValue(SHORT_DESCRIPTION,"Brise pojam ili vezu");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startEraseState();
    }
}
