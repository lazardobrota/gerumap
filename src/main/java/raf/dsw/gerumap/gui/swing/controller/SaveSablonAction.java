package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MainPanel;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class SaveSablonAction extends AbstractGerumapAction{

    public SaveSablonAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));//ACCELERATOR_KEY - zadajemo precicu
        putValue(SMALL_ICON, loadIcon("/images/sablon.png"));//jos uvek nemam nista u images paketu ali dodaje ikonicu za New Project, verovatno u MenuBar ako tamo napravimo instancu klase
        putValue(NAME, "Sablon");//Zvace se New Project
        putValue(SHORT_DESCRIPTION, "Napravi novi sablon");//Ono sto ce pisati ako drzimo mis duze na ikonicu kao objasnjenje sta radi
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(  "src\\main\\resources\\sablonJsonFiles"));
        MindMap mindmap = null;

        if (MainPanel.getInstance().getTabsPanel().getSelectedComponent() == null) {//Ako nista nije selektovano
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.NOTHING_IS_SELECTED);
            return;
        }


        mindmap = ((MindMapView) MainPanel.getInstance().getTabsPanel().getSelectedComponent()).getMindMap();

        if (mindmap ==null)//Nije selektovano ono sto moze da se sacuva
            return;

        File mindMapFile = null;

        Project project = (Project) mindmap.getParent();

        if (mindmap.getSablonFilePath() == null || mindmap.getSablonFilePath().isEmpty()) {
            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                mindMapFile = jfc.getSelectedFile();
                mindmap.setSablonFilePath(mindMapFile.getPath());
            } else {
                return;
            }

        }


        ApplicationFramework.getInstance().getSerializer().saveSablon(mindmap);

        //mindmap.setSablonChanged(false);
    }
}
