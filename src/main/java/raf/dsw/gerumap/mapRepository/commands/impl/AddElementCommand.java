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

public class AddElementCommand extends AbstractCommand {

    private MindMapView mindMapView;
    private Element element;

    public AddElementCommand(MindMapView mindMapView, Element element) {
        this.mindMapView = mindMapView;
        this.element = element;
    }

    @Override
    public void doCommand() {
        if(element == null || mindMapView == null ||  mindMapView.getMindMap() == null)
            return;

        if (element instanceof Veza) {
            Veza veza = (Veza) element;
            mindMapView.getElementPainterList().add(new VezaPainter(veza));//apdejtuje vezu da zapravo postoji
            mindMapView.getMindMap().addChild(veza);//Dobra je veza i dodaje se u decu mape uma
            return;
        }

        Pojam pojam = (Pojam) element;
        MindMap mindMap = mindMapView.getMindMap();
        int numChildern = mindMap.getChildren().size();

        //Dodaje dete i poziva se update
        mindMap.addChild(pojam);
        String name = pojam.getIme();
        //Vec postoji dete sa tim imenom ako nije dodato
        while (numChildern == mindMap.getChildren().size()) {
            pojam.setIme(name + mindMap.getNumberingChildren());
            mindMap.addChild(pojam);
        }

        mindMapView.getElementPainterList().add(new PojamPainter(pojam));//u listu paintera za tu mapu uma se dodaje pojam
    }

    @Override
    public void undoCommand() {
        if(element == null || mindMapView == null ||  mindMapView.getMindMap() == null)
            return;

        //Brise iz selektovanih ako postoji tamo
        mindMapView.getMapSelectionModel().getSelectedElements().remove(element);

        Iterator<ElementPainter> iteratorPainter = mindMapView.getElementPainterList().iterator();
        //Prolazi kroz sve Paintere
        while (iteratorPainter.hasNext()) {
            Element elementPainter = iteratorPainter.next().getElement();
            if (element.equals(elementPainter)) {
                iteratorPainter.remove();//Brise iz liste paintera
                break;
            }
        }

        mindMapView.getMindMap().deleteChild(element);//Brise iz liste dece
        System.out.println(mindMapView.getMindMap().getChildren().size());
    }
}
