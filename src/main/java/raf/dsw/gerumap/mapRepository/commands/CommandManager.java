package raf.dsw.gerumap.mapRepository.commands;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private List<AbstractCommand> commands = new ArrayList<>();
    private int counter = 0;

    //dodaje se nova komanda na stek
    public void addCommand(AbstractCommand command){
        //Brise sve redo koji su mogli da idu
        while(counter < commands.size()){
            commands.remove(counter);
        }
        commands.add(command);
        //izvrsavamo komadu
        this.doCommandManager();
    }

    public void doCommandManager(){
        if(counter < commands.size()){
            commands.get(counter++).doCommand();
            ApplicationFramework.getInstance().getGui().enableUndoAction();//Undo - unazad
        }
        if(counter == commands.size()){
            ApplicationFramework.getInstance().getGui().disableRedoAction();//Redo - unapred
        }
    }

    //Metoda koja poziva redo konkretne komande
    public void undoCommandManager(){
        if(counter > 0){
            ApplicationFramework.getInstance().getGui().enableRedoAction();
            commands.get(--counter).undoCommand();
        }
        if(counter == 0){
            ApplicationFramework.getInstance().getGui().disableUndoAction();
        }
    }
}
