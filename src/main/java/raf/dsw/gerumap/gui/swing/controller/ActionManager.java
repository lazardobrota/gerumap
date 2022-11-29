package raf.dsw.gerumap.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.controller.verticalButtons.AddElementAction;
import raf.dsw.gerumap.gui.swing.controller.verticalButtons.ConnectAction;
import raf.dsw.gerumap.gui.swing.controller.verticalButtons.MoveAction;
import raf.dsw.gerumap.gui.swing.controller.verticalButtons.SelectAction;

@Getter
@Setter
public class ActionManager {

    private InfoAction infoAction;
    private NewProjectAction newProjectAction;
    private AutorAction editAction;
    private OkAction okAction;
    private DeleteChildAction deleteChildAction;
    private SaveAction autorAction;

    //Vertikalni dugmici
    private AddElementAction addElementAction;
    private ConnectAction connectAction;
    private MoveAction moveAction;
    private SelectAction selectAction;

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

        addElementAction = new AddElementAction();
        connectAction = new ConnectAction();
        moveAction = new MoveAction();
        selectAction = new SelectAction();
    }

}
