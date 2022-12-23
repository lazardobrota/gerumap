package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

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

        if (MainFrame.getInstance().getMapTree().getSelectedNode() == null) {//Ako nista nije selektovano
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.NOTHING_IS_SELECTED);
            return;
        }

        if (MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof ProjectExplorer) {//ProjectExplorer je selektovan
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.CANNOT_SAVE_PROJECT_EXPLORER);
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
