package raf.dsw.gerumap.mapRepository.commands.impl;

import raf.dsw.gerumap.gui.swing.view.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.gui.swing.view.PojamPainter;
import raf.dsw.gerumap.gui.swing.view.VezaPainter;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.Veza;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EraseElementCommand implements AbstractCommand {

    private MindMap mindMap;
    private List<Element> elements = new ArrayList<>();

    public EraseElementCommand(MindMap mindMap, List<Element> elements) {
        this.mindMap = mindMap;
        this.elements.addAll(elements);//Ovako su dodati elementi kako bi izbegli pokazivace izmejdu this.elements i elements jer se elements restartuje na svako pozivanje brisanja
    }

    @Override
    public void doCommand() {//Brise element
        if(elements == null || mindMap == null)
            return;

        for (Element element : elements) {
            mindMap.deleteChild(element);
        }
    }

    @Override
    public void undoCommand() {//Dodaje element
        if(elements == null || mindMap == null)
            return;

        for (Element element : elements) {
            mindMap.addChild(element);
        }
    }
}
