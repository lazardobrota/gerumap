package raf.dsw.gerumap.mapRepository.commands;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private List<AbstractCommand> commands = new ArrayList<>();
    private int counter = 0;

    public void addCommand(AbstractCommand command){
        // dodaje se nova komanda na stek
        while(counter < commands.size()){
            commands.remove(counter);
        }
        commands.add(command);
        //izvrsavamo komadu
        this.doCommand();
    }

    public void doCommand(){
        if(counter < commands.size()){
            commands.get(counter++).doCommand();
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMapTree().getTreeView());
            ApplicationFramework.getInstance().getGui().enableUndoAction();
        }
        if(counter == commands.size()){
            ApplicationFramework.getInstance().getGui().disableRedoAction();
        }
    }

    /*
     * Metoda koja poziva redo konkretne komande
     */
    public void undoCommand(){
        if(counter > 0){
            ApplicationFramework.getInstance().getGui().enableRedoAction();
            commands.get(--counter).undoCommand();
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMapTree().getTreeView());
        }
        if(counter == 0){
            ApplicationFramework.getInstance().getGui().disableUndoAction();
        }
    }
}
