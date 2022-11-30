package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.mapRepository.implementation.Element;

import java.awt.*;

public class PojamPainter extends ElementPainter{

    //todo gde pravimo shape
    private Shape shape;//Ima razlicite oblike, elipsa, pravougaonik, ...

    public PojamPainter(Element element) {
        super(element);
    }

    //todo
    @Override
    public void draw(Graphics2D g, Element element) {

    }

    //todo
    @Override
    public boolean elementAt(Element element, Point position) {
        return false;
    }
}
