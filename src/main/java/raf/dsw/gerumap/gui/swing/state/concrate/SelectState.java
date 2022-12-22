package raf.dsw.gerumap.gui.swing.state.concrate;

import raf.dsw.gerumap.gui.swing.view.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.gui.swing.view.PojamPainter;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.*;

public class SelectState extends State {

    //central coordinates
    static int x;
    static int y;

    @Override
    public void pressed(int x, int y, MindMapView m) {
        m.getMapSelectionModel().getSelectedElements().clear();//Obrise sve prethodne selektovane

        //Pravimo lazni pojam koji prati mis za selektovanje
        Pojam pojam = new Pojam(new Dimension(1, 1), new Point(x, y));
        pojam.addSubs(m);
        pojam.setColor(Color.DARK_GRAY.getRGB());
        pojam.setStroke(2);
        m.getMapSelectionModel().setFakePojam(pojam);
        SelectState.x = x;
        SelectState.y = y;
    }

    @Override
    public void released(int x, int y, MindMapView m) {
        Pojam pojam = m.getMapSelectionModel().getFakePojam();
        for (ElementPainter elementPainter : m.getElementPainterList()) {
            //Samo za pojmove dodaje u selektovane
            if (elementPainter instanceof PojamPainter && elementPainter.elementAt(pojam, pojam.getPosition())) {
                m.getMapSelectionModel().getSelectedElements().add(elementPainter.getElement());
            }
        }

        m.getMapSelectionModel().setFakePojam(null);
    }

    /*
         (0,0)       | y-
                     |
          x-  -------|------- x+
                     |
                     | y+   (max, max)
     */
    @Override
    public void dragged(int x, int y, MindMapView m) {
        int width = 0;
        int height = 0;
        Pojam pojam = m.getMapSelectionModel().getFakePojam();

        /*
        System.out.println("x: " + x + ", SelectState.x: " + SelectState.x);
        System.out.println("y: " + y + ", SelectState.y: " + SelectState.y);
        System.out.println("----------------------------------------------");
         */

        //Prvi kvadrant x >, y <
        if (x > SelectState.x && y < SelectState.y) {
            pojam.setPosition(new Point(SelectState.x, y));
            width = Math.abs(SelectState.x - x);
            height = Math.abs(SelectState.y - pojam.getPosition().y);
        }

        //Drugi kvadrant x <, y <
        if (x <= SelectState.x && y <= SelectState.y) {
            pojam.setPosition(new Point(x, y));
            width = Math.abs(SelectState.x - pojam.getPosition().x);
            height = Math.abs(SelectState.y - pojam.getPosition().y);
        }

        //Treci kvadrant x <, y >
        if (x < SelectState.x && y > SelectState.y) {
            pojam.setPosition(new Point(x, SelectState.y));
            width = Math.abs(SelectState.x - pojam.getPosition().x);
            height = Math.abs(SelectState.y - y);
        }

        //Cetvrti kvadrant x >, y >
        if (x > SelectState.x && y > SelectState.y) {
            pojam.setPosition(new Point(SelectState.x, SelectState.y));
            width = Math.abs(SelectState.x - x);
            height = Math.abs(SelectState.y - y);
        }

        pojam.setDimension(new Dimension(width, height));
        m.getMapSelectionModel().setFakePojam(pojam);
    }
}
