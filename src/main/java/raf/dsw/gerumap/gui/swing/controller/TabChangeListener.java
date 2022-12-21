package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainPanel;
import raf.dsw.gerumap.gui.swing.view.MindMapView;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabChangeListener implements ChangeListener {

    @Override
    public void stateChanged(ChangeEvent e) {//Ako je promenjen tab
        MindMapView mindMapView = (MindMapView) MainPanel.getInstance().getTabsPanel().getSelectedComponent();
        if (mindMapView == null)
            return;

        mindMapView.getMindMap().getCommandManager().changeCommandManager();
    }
}
