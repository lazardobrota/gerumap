package raf.dsw.gerumap.mapRepository.commands.impl;

import raf.dsw.gerumap.gui.swing.view.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.gui.swing.view.PojamPainter;
import raf.dsw.gerumap.gui.swing.view.VezaPainter;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.Veza;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EraseElementCommand extends AbstractCommand {

    MindMapView mindMapView;
    List<Element> elements = new ArrayList<>();

    public EraseElementCommand(MindMapView mindMapView, List<Element> elements) {
        this.mindMapView = mindMapView;
        this.elements.addAll(elements);//Ovako su dodati elementi kako bi izbegli pokazivace izmejdu this.elements i elements jer se elements restartuje na svako pozivanje brisanja
    }



    @Override
    public void doCommand() {//Brise element
        Iterator<ElementPainter> iteratorPainter = mindMapView.getElementPainterList().iterator();

        //Prolazi kroz sve Paintere
        while (iteratorPainter.hasNext()) {
            Element elementPainter = iteratorPainter.next().getElement();
            //Ako su im ista imena nasli smo element koji trebamo svuda da uklonimo
            if (elements.contains(elementPainter)) {
                mindMapView.getMindMap().deleteChild(elementPainter);//Brise iz mape uma
                mindMapView.getMapSelectionModel().getSelectedElements().remove(elementPainter);//Brise iz selektovanih
                iteratorPainter.remove();//Brise iz paintera
            }
        }
    }

    @Override
    public void undoCommand() {//Dodaje element

        for (Element element : elements) {

            //Vraca u listu paintera
            if (element instanceof Pojam)
                mindMapView.getElementPainterList().add(new PojamPainter(element));
            else
                mindMapView.getElementPainterList().add(new VezaPainter(element));

            mindMapView.getMindMap().addChild(element);
        }
    }
}
