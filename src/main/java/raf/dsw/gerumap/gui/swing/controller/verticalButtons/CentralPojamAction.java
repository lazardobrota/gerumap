package raf.dsw.gerumap.gui.swing.controller.verticalButtons;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class CentralPojamAction extends AbstractGerumapAction {

    public CentralPojamAction(){
        putValue(SMALL_ICON,loadIcon("/images/centralPojam.png"));
        putValue(NAME,"Central pojam");
        putValue(SHORT_DESCRIPTION,"Postavlja pojam na centar i ostale pojmove oko njega");
    }

    @Override
    public void actionPerformed(ActionEvent e) { MainFrame.getInstance().getProjectView().startCentralPojamState();}
}
