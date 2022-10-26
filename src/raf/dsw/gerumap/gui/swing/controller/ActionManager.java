package raf.dsw.gerumap.gui.swing.controller;

public class ActionManager {

    private EditAction editAction;
    private NewProjectAction newProjectAction;

    public ActionManager() {
        initActions();
    }

    private void initActions() {
        editAction = new EditAction();
        newProjectAction = new NewProjectAction();
    }

    public EditAction getExitAction() {
        return editAction;
    }

    public void setExitAction(EditAction exitAction) {
        this.editAction = exitAction;
    }

    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public void setNewProjectAction(NewProjectAction newProjectAction) {
        this.newProjectAction = newProjectAction;
    }
}
