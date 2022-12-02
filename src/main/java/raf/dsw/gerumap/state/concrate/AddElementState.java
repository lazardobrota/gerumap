package raf.dsw.gerumap.state.concrate;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
import raf.dsw.gerumap.gui.swing.view.*;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.state.State;

import java.awt.*;

public class AddElementState extends State {

    @Override
    public void pressed(int x, int y, MindMapView m) {
        MindMap mindMap = m.getMindMap();
        Dimension dimension = new Dimension(50, 50); //Lazni pojam gde samo proveravamo da li postoji nesto na tim koordinatama
        int x2 = coordinate(x, dimension.width);
        int y2 = coordinate(y, dimension.height);
        Pojam pojam = new Pojam(dimension, new Point(Math.abs(x2), Math.abs(y2)));

        for (ElementPainter elementPainter : m.getElementPainterList()) {
            //Vec postoji na toj poziciji takav pojam
            if (elementPainter.elementAt(pojam, pojam.getPosition())) {
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.POSITION_TAKEN);
                return;
            }
        }

        //Moze da se pravi pravi pojam jer ima slobodan prostor da se napravi
        pojam = new Pojam("Pojam" + mindMap.getNumberingChildren(), mindMap, dimension, new Point(Math.abs(x2), Math.abs(y2)));//todo na osnovu teksta napravi dimenziju
        m.getElementPainterList().add(new PojamPainter(pojam));//u listu paintera za tu mapu uma se dodaje pojam

        //Dodaje dete i poziva se update
        mindMap.addChild(pojam);//todo treba i u stablu da se doda
        //MainFrame.getInstance().getMapTree().addChild(mindMap);
        System.out.println("Add");
    }

    private int coordinate(int c, int dimension) {
        int c2 = c - dimension / 2;

        //Ako je van panela i ide u minus
        if (c2 < 0)
            c2 = 0;

        //todo da li treba i uslov ako je duze od panela(previse desno ili previse dole)

        return c2;
    }
}
