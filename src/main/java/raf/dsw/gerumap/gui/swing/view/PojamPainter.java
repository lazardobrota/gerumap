package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;

import java.awt.*;

public class PojamPainter extends ElementPainter{

    public PojamPainter(Element element) {
        super(element);
    }

    //todo
    @Override
    public void draw(Graphics2D g, Element element) {
        Pojam p = (Pojam) element;
        System.out.println("draw");
        g.setPaint(p.getColor());//todo treba da se doda metoda
        //x - p.getDimension().width/2, y - p.getDimension().height/2 u argumentu postavljaju na sredinu misa da se postavi krug
        g.drawOval(p.getPosition().x - p.getDimension().width/2, p.getPosition().y - p.getDimension().height/2, p.getDimension().width, p.getDimension().height);//TODO treba elipsa sa podesenim tekstom da bude
    }

    //todo
    @Override
    public boolean elementAt(Element element, Point position) {
        return false;
    }
}
