package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.Veza;

import java.awt.*;
import java.awt.geom.Line2D;

public class VezaPainter extends ElementPainter{


    public VezaPainter(Element element) {
        super(element);
    }

    //todo
    @Override
    public void draw(Graphics2D g, Element element) {
        Veza veza = (Veza) element;
    }

    //todo
    //ovo sluzi da znamo da li smo pogodili jedan pojam kako bi mogli vezu da povucemo iz njega
    @Override
    public boolean elementAt(Element element, Point position) {
        if (element instanceof Veza)//Mora pojam da pogodi
            return false;

        Pojam pojam = (Pojam) element;

        return false;
    }
}
