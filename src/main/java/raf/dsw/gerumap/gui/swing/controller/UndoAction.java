package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.view.MainPanel;
import raf.dsw.gerumap.gui.swing.view.MindMapView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class UndoAction extends AbstractGerumapAction{

    public UndoAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/undo.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MindMapView mindMapView = (MindMapView) MainPanel.getInstance().getTabsPanel().getSelectedComponent();
        if (mindMapView == null)
            return;

        mindMapView.getMindMap().getCommandManager().undoCommandManager();
    }
}
