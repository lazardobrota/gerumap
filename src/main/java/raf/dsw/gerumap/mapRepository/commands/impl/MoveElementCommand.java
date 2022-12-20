package raf.dsw.gerumap.mapRepository.commands.impl;

import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

import java.util.List;

public class MoveElementCommand implements AbstractCommand {
    private MindMap mindMap;
    private List<Element> elementList;

    public MoveElementCommand(MindMap mindMap, List<Element> elementList) {
        this.mindMap = mindMap;
        this.elementList = elementList;
    }

    @Override
    public void doCommand() {
        if(elementList == null || mindMap == null)
            return;


    }

    @Override
    public void undoCommand() {

    }
}
