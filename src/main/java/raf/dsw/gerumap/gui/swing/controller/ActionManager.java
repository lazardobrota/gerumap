package raf.dsw.gerumap.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.view.InfoFrame;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

@Getter
@Setter
public class ActionManager {

    private InfoAction infoAction;
    private NewProjectAction newProjectAction;
    private EditAction editAction;
    private OkAction okAction;

    public ActionManager() {
        initActions();
    }

    private void initActions() {
        infoAction = new InfoAction();
        newProjectAction = new NewProjectAction();
        editAction = new EditAction();
        okAction = new OkAction();
    }

}
