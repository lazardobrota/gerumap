package raf.dsw.gerumap.mapRepository.commands;

public interface AbstractCommand {

    public  void doCommand();
    public  void undoCommand();
}
