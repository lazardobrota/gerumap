package raf.dsw.gerumap.mapRepository.commands;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.core.ApplicationFramework;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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

    public void changeCommandManager() {
        if(counter < commands.size()){//Moze i levo i desno da ide ako je counter manji
            ApplicationFramework.getInstance().getGui().enableUndoAction();//Undo - unazad
            ApplicationFramework.getInstance().getGui().enableRedoAction();//Redo - unapred
        }

        if(!commands.isEmpty()){//Ako nije prazno to znaci da moze na nesto undo da se uradi
            ApplicationFramework.getInstance().getGui().enableUndoAction();//Undo - unazad
        }
        if (counter == 0) {//Ako je counter 0 ne moze vise undo da radi
            ApplicationFramework.getInstance().getGui().disableUndoAction();//Undo - unazad
        }
        if(counter == commands.size()){//Ako je counter skroz desno ne moze vise redo a radi
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
