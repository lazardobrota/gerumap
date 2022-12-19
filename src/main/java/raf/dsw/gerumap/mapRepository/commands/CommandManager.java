package raf.dsw.gerumap.mapRepository.commands;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.core.ApplicationFramework;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommandManager {

    //todo da li treba da se cuva redo i undo ako se promeni mapa uma na tabu
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

    public void restartCommands() {
        commands.clear();
        counter = 0;
        ApplicationFramework.getInstance().getGui().disableRedoAction();
        ApplicationFramework.getInstance().getGui().disableUndoAction();

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
