package raf.dsw.gerumap.gui.swing.controller.verticalButtons;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ZoomAction extends AbstractGerumapAction {

    public ZoomAction() {
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,loadIcon("/images/zoom.png"));
        putValue(NAME,"Zoom");
        putValue(SHORT_DESCRIPTION,"Zumiranje po platnu");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startZoomState();
    }
}
