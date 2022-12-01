package raf.dsw.gerumap.state.concrate;

import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.gui.swing.view.PojamPainter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.state.State;

import java.awt.*;

public class AddElementState extends State {

    @Override
    public void pressed(int x, int y, MindMapView m) {
        MindMap mindMap = m.getMindMap();
        Pojam pojam = new Pojam("Pojam" + mindMap.getNumberingChildren(), mindMap, new Dimension(50, 50), new Point(x, y));//todo na osnovu teksta napravi dimenziju
        m.getElementPainterList().add(new PojamPainter(pojam));//u listu paintera za tu mapu uma se dodaje pojam

        //Dodaje dete i poziva se update
        mindMap.addChild(pojam);
        System.out.println("Add");
    }
}
