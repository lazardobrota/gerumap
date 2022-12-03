package raf.dsw.gerumap.gui.swing.controller.verticalButtons;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.ColorFrame;

import java.awt.event.ActionEvent;

public class ColorAction extends AbstractGerumapAction {

    public ColorAction(){
        putValue(SMALL_ICON,loadIcon("/images/color.png"));
        putValue(NAME,"Color");
        putValue(SHORT_DESCRIPTION,"Boji elemente u izabranu boju");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ColorFrame.getInstance().setVisible(true);
    }
}
