package raf.dsw.gerumap.mapRepository.commands.impl;

import raf.dsw.gerumap.gui.swing.view.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.gui.swing.view.PojamPainter;
import raf.dsw.gerumap.gui.swing.view.VezaPainter;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.Veza;

import java.util.Iterator;
import java.util.List;

public class AddElementCommand implements AbstractCommand {

    private MindMap mindMap;
    private Element element;

    public AddElementCommand(MindMap mindMap, Element element) {
        this.mindMap = mindMap;
        this.element = element;
    }

    @Override
    public void doCommand() {
        if(element == null ||  mindMap == null)
            return;

        if (element instanceof Veza) {
            Veza veza = (Veza) element;
            //mindMapView.getElementPainterList().add(new VezaPainter(veza));//apdejtuje vezu da zapravo postoji
            mindMap.addChild(veza);//Dobra je veza i dodaje se u decu mape uma
            return;
        }

        Pojam pojam = (Pojam) element;
        int numChildern = mindMap.getChildren().size();

        //Dodaje dete i poziva se update
        mindMap.addChild(pojam);
        String name = pojam.getIme();
        //Vec postoji dete sa tim imenom ako nije dodato
        while (numChildern == mindMap.getChildren().size()) {
            pojam.setIme(name + mindMap.getNumberingChildren());
            mindMap.addChild(pojam);
        }

        //mindMapView.getElementPainterList().add(new PojamPainter(pojam));//u listu paintera za tu mapu uma se dodaje pojam
    }

    @Override
    public void undoCommand() {
        if(element == null || mindMap == null)
            return;

        mindMap.deleteChild(element);//Brise iz liste dece
        System.out.println(mindMap.getChildren().size());
    }
}
