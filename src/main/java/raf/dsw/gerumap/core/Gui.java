package raf.dsw.gerumap.core;

import raf.dsw.gerumap.gui.swing.observer.Subscriber;
import raf.dsw.gerumap.mapRepository.commands.CommandManager;

public interface Gui extends Subscriber {

    void start();

    void enableUndoAction();
    void enableRedoAction();

    void disableUndoAction();
    void disableRedoAction();
    CommandManager getCommandManager();
}
