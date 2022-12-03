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

    //todo ne treba vise puta ista veza za dva pojma
    @Override
    public void draw(Graphics2D g, Element element) {
        Veza veza = (Veza) element;
        int x = veza.getFrom().getPosition().x;
        int y =veza.getFrom().getPosition().y;
        int x2 =veza.getTo().getPosition().x;
        int y2 =veza.getTo().getPosition().y;

        //From - pocetni pojam
        int xLeft = x;
        int yLeft = y + veza.getFrom().getDimension().height/2;
        int left = y + veza.getFrom().getDimension().height/2;// -0

        int xUp = x + veza.getFrom().getDimension().width/2;
        int yUp = y;
        int up = x + veza.getFrom().getDimension().width/2;// |
        //                                                    0

        int xRight = x + veza.getFrom().getDimension().width;
        int yRight = left;
        int right = x + veza.getFrom().getDimension().width + left;// 0-

        int xDown = up;
        int yDown = y + veza.getFrom().getDimension().height;
        int down = y + veza.getFrom().getDimension().height + up;// 0
        //                                                          |
        double min = 9999;
        double intezitet = Math.sqrt(Math.pow(xLeft - x2, 2) + Math.pow(yLeft - y2, 2));
        int xx = x;
        int yy = y;
        if (min > intezitet) {
            min = intezitet;
            xx = xLeft;
            yy = yLeft;
        }
        intezitet = Math.sqrt(Math.pow(xUp - x2, 2) + Math.pow(yUp - y2, 2));
        if (min > intezitet) {
            min = intezitet;
            xx = xUp;
            yy = yUp;
        }
        intezitet = Math.sqrt(Math.pow(xRight - x2, 2) + Math.pow(yRight - y2, 2));
        if (min > intezitet) {
            min = intezitet;
            xx = xRight;
            yy = yRight;
        }
        intezitet = Math.sqrt(Math.pow(xDown - x2, 2) + Math.pow(yDown - y2, 2));
        if (min > intezitet) {
            min = intezitet;
            xx = xDown;
            yy = yDown;
        }

        //To - krajni pojam
        int x2Left = x2;
        int y2Left = y2 + veza.getTo().getDimension().height/2;
        int left2 = y2 + veza.getTo().getDimension().height/2;

        int x2Up = x2 + veza.getTo().getDimension().width/2;
        int y2Up = y2;
        int up2 = x2 + veza.getTo().getDimension().width/2;

        int x2Right = x2 + veza.getTo().getDimension().width;
        int y2Right = left2;
        int right2 = x2+ veza.getTo().getDimension().width + left2;

        int x2Down = up2;
        int y2Down = y2 + veza.getTo().getDimension().height;
        int down2 = y2 + veza.getTo().getDimension().height + up2;

        min = 9999;
        intezitet = Math.sqrt(Math.pow(x2Left - xx, 2) + Math.pow(y2Left - yy, 2));
        int xx2 = x2;
        int yy2 = y2;
        if (min > intezitet) {
            min = intezitet;
            xx2 = x2Left;
            yy2 = y2Left;
        }
        intezitet = Math.sqrt(Math.pow(x2Up - xx, 2) + Math.pow(y2Up - yy, 2));
        if (min > intezitet) {
            min = intezitet;
            xx2 = x2Up;
            yy2 = y2Up;
        }
        intezitet = Math.sqrt(Math.pow(x2Right - xx, 2) + Math.pow(y2Right - yy, 2));
        if (min > intezitet) {
            min = intezitet;
            xx2 = x2Right;
            yy2 = y2Right;
        }
        intezitet = Math.sqrt(Math.pow(x2Down - xx, 2) + Math.pow(y2Down - yy, 2));
        if (min > intezitet) {
            min = intezitet;
            xx2 = x2Down;
            yy2 = y2Down;
        }

        shape = new Line2D.Float(xx, yy, xx2, yy2);
        g.setPaint(veza.getColor());
        g.setStroke(new BasicStroke(veza.getStroke()));
        g.draw(shape);
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

    private double milankaIntezitet(double min, int x1, int x2, int y1, int y2) {


        return min;
    }
}
