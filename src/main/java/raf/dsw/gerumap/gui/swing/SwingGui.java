package raf.dsw.gerumap.gui.swing;

import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.gui.swing.messageGen.Message;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.commands.CommandManager;

public class SwingGui implements Gui {

    private CommandManager commandManager;

    public SwingGui() {
    }

    @Override
    public void start() {
        MainFrame.getInstance().setVisible(true);
        commandManager = new CommandManager();

        //hocemo da zabranimo korisniku da pritisne undo i redo posto nije jos nista uradio
        this.disableUndoAction();
        this.disableRedoAction();
    }

    @Override
    public void enableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
    }

    @Override
    public void enableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
    }

    @Override
    public void disableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
    }

    @Override
    public void disableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
    }

    @Override
    public CommandManager getCommandManager() {
        return commandManager;
    }

    @Override
    public void update(Object notification) {
        MainFrame.getInstance().errorMessage((Message) notification);
    }
}
