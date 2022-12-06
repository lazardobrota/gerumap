package raf.dsw.gerumap.state.concrate;

import raf.dsw.gerumap.gui.swing.view.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.gui.swing.view.PojamPainter;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.Veza;
import raf.dsw.gerumap.state.State;

import java.awt.*;

public class MoveState extends State {
    //Originalne koordinate gde je prvi put pritisnut kursor
    static int x;
    static int y;
    //Cuva prethodne koordinate
    static int lastX;
    static int lastY;
    @Override
    public void pressed(int x, int y, MindMapView m) {
        //Pocetne koordinate
        MoveState.x = MoveState.lastX = x;
        MoveState.y = MoveState.lastY = y;
    }

    //todo treba da se vrati na originalnu poziciju ako je trenutna zauzeta
    @Override
    public void released(int x, int y, MindMapView m) {
        /*
        for (Element element : m.getMapSelectionModel().getSelectedElements()) {
            if (element instanceof Veza)
                continue;

            for (ElementPainter elementPainter : m.getElementPainterList()) {
                Pojam pojam = (Pojam) element;
                if (elementPainter instanceof PojamPainter && elementPainter.elementAt(pojam, pojam.getPosition())) {
                    //Mora da se vrati na staru poziciju jer je nova zauzeta
                    int px = pojam.getPosition().x - (lastX - MoveState.x);
                    int py = pojam.getPosition().y - (lastY - MoveState.y);
                    pojam.setPosition(new Point(px, py));
                }
            }
        }
         */
    }

    @Override
    public void dragged(int x, int y, MindMapView m) {
        for (Element element : m.getMapSelectionModel().getSelectedElements()) {
            if (element instanceof Veza)
                continue;
            Pojam pojam = (Pojam) element;

            int px = pojam.getPosition().x + (x - MoveState.lastX);
            int py = pojam.getPosition().y + (y - MoveState.lastY);

            /*
            System.out.println("x: " + pojam.getPosition().x + ", px: " + px);
            System.out.println("y: " + pojam.getPosition().y + ", py " + py);
            System.out.println("----------------------------------------------");
             */
            pojam.setPosition(new Point(px, py));
        }

        MoveState.lastX = x;
        MoveState.lastY = y;
    }
}
