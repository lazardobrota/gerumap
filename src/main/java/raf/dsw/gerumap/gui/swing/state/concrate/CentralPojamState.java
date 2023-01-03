package raf.dsw.gerumap.gui.swing.state.concrate;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
import raf.dsw.gerumap.gui.swing.state.State;
import raf.dsw.gerumap.gui.swing.view.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.commands.impl.AddElementCommand;
import raf.dsw.gerumap.mapRepository.commands.impl.CentralPojamCommand;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.Veza;

import java.awt.*;

public class CentralPojamState extends State {
    @Override
    public void pressed(int x, int y, MindMapView m) {

        //Pojam koji koristimo kao hitbox
        Pojam hitbox = new Pojam(new Dimension(10, 10), new Point(x, y));

        //Proverava da li je pogodjen neki element
        for (ElementPainter elementPainter : m.getElementPainterList()) {
            //Nastavi dalje jer nije to taj element
            if (elementPainter.getElement() instanceof Veza || !elementPainter.elementAt(hitbox, hitbox.getPosition()))
                continue;

            //Pogodjen je element
            Pojam element = (Pojam) elementPainter.getElement();
            Point newPoint = new Point(m.getWidth()/2, m.getHeight()/2);
            hitbox.setPosition(newPoint);
            for (ElementPainter painter : m.getElementPainterList()) {
                //Nastavi dalje jer nije to taj element
                if (painter.getElement() instanceof Veza || !painter.elementAt(hitbox, hitbox.getPosition()))
                    continue;

                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.POSITION_TAKEN);
                return;//Vec se nalazi na toj poziciji element pa na moze jos jedan
            }

            AbstractCommand command = new CentralPojamCommand(element, element.getPosition(), newPoint);
            m.getMindMap().getCommandManager().addCommand(command);
            break;
        }
    }
}
