package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.mapRepository.implementation.Element;

import java.awt.*;

public class VezaPainter extends ElementPainter{


    public VezaPainter(Element element) {
        super(element);
    }

    //todo
    @Override
    public void draw(Graphics2D g, Element element) {

    }

    //todo
    //ovo sluzi da znamo da li smo pogodili jedan pojam kako bi mogli vezu da povucemo iz njega
    @Override
    public boolean elementAt(Element element, Point position) {
        return false;
    }
}
