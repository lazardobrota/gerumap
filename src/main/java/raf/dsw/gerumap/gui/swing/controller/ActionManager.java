package raf.dsw.gerumap.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.controller.verticalButtons.*;

@Getter
@Setter
public class ActionManager {

    private InfoAction infoAction;
    private NewProjectAction newProjectAction;
    private AutorAction editAction;
    private OkAction okAction;
    private DeleteChildAction deleteChildAction;
    private SaveAction autorAction;
    private ChooseAction chooseAction;
    private ClosingColorAction closingColorAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private OpenProjectAction openProjectAction;
    private SaveFileAction saveFileAction;
    private SaveSablonAction saveSablonAction;
    private ExportImageAction exportImageAction;

    private TabChangeListener tabChangeListener;//Listener za tab


    //Vertikalni dugmici
    private AddElementAction addElementAction;
    private CentralPojamAction centralPojamAction;
    private ConnectAction connectAction;
    private EraseAction eraseAction;
    private MoveAction moveAction;
    private SelectAction selectAction;
    private ZoomInAction zoomInAction;
    private ZoomOutAction zoomOutAction;
    private ColorAction colorAction;

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
        chooseAction = new ChooseAction();
        closingColorAction = new ClosingColorAction();
        saveSablonAction = new SaveSablonAction();
        exportImageAction = new ExportImageAction();

        tabChangeListener = new TabChangeListener();

        addElementAction = new AddElementAction();
        centralPojamAction = new CentralPojamAction();
        connectAction = new ConnectAction();
        eraseAction = new EraseAction();
        moveAction = new MoveAction();
        selectAction = new SelectAction();
        zoomInAction = new ZoomInAction();
        zoomOutAction = new ZoomOutAction();
        colorAction = new ColorAction();
        undoAction = new UndoAction();
        redoAction = new RedoAction();
        openProjectAction = new OpenProjectAction();
        saveFileAction = new SaveFileAction();
    }

}
