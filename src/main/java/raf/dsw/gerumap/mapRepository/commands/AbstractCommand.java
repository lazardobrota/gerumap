package raf.dsw.gerumap.mapRepository.commands;

public abstract class AbstractCommand {

    public abstract void doCommand();
    public abstract void undoCommand();
}