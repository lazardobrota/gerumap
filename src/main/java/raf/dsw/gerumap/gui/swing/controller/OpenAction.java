package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class OpenAction extends AbstractGerumapAction{

    public OpenAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/open.png"));
        putValue(NAME, "Open action");
        putValue(SHORT_DESCRIPTION, "Open action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = jfc.getSelectedFile();
                Project p = ApplicationFramework.getInstance().getSerializer().loadProject(file);
                MainFrame.getInstance().getMapTree().loadProject(p);

            } catch (Exception en) {
                en.printStackTrace();
            }
        }
    }
}
