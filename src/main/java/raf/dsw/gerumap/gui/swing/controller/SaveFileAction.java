package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class SaveFileAction extends AbstractGerumapAction {

    public SaveFileAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/save.png"));
        putValue(NAME, "Save action");
        putValue(SHORT_DESCRIPTION, "Save action");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        Project project = null;

        //todo nekad ne hvata null iako treba
        if (MainFrame.getInstance().getMapTree().getSelectedNode() == null) {//Ako nista nije selektovano
            return;
        }

        if (MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project) { //Projekat je selektovan
            project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        }
        else if (MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode().getParent() instanceof Project) { //MindMap je selektovan
            project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode().getParent();
        }
        else if (MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode().getParent().getParent() instanceof Project) { //Element je selektovan
            project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode().getParent().getParent();
        }

        if (project ==null)//Nije selektovano ono sto moze da se sacuva
            return;

        File projectFile = null;

        if (!project.isChanged()) {
            return;
        }

        if (project.getFilePath() == null || project.getFilePath().isEmpty()) {
            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                projectFile = jfc.getSelectedFile();
                project.setFilePath(projectFile.getPath());
            } else {
                return;
            }

        }


        ApplicationFramework.getInstance().getSerializer().saveProject(project);

        project.setChanged(false);
    }
}
