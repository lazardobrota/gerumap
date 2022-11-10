package raf.dsw.gerumap.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {

    private InfoAction infoAction;
    private NewProjectAction newProjectAction;
    private AutorAction editAction;
    private OkAction okAction;
    private DeleteChildAction deleteChildAction;
    private SaveAction autorAction;
    private NewAction newAction;

    public ActionManager() {
        initActions();
    }

    private void initActions() {
        infoAction = new InfoAction();
        newProjectAction = new NewProjectAction();
        editAction = new AutorAction();
        okAction = new OkAction();
        deleteChildAction = new DeleteChildAction();
        autorAction = new SaveAction();
        newAction = new NewAction();
    }

}
