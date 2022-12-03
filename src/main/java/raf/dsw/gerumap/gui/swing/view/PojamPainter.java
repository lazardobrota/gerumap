package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.Veza;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class PojamPainter extends ElementPainter{

    public PojamPainter(Element element) {
        super(element);
    }

    @Override
    public void draw(Graphics2D g, Element element) {
        Pojam p = (Pojam) element;
        g.setPaint(p.getColor());
        g.setStroke(new BasicStroke(p.getStroke()));
        int x = p.getPosition().x;
        int y = p.getPosition().y;

        shape = new Ellipse2D.Float(x, y, p.getDimension().width, p.getDimension().height); //TODO treba elipsa sa podesenim tekstom da bude

        g.draw(shape);
        g.drawString(p.getIme(), x + p.getDimension().width/2, y + p.getDimension().height/2);
    }

    @Override
    public boolean elementAt(Element element, Point position) {
        //Pojam
        Pojam pojam = (Pojam) this.element;//Pojam ove klase koji je vec dodat

        if (element instanceof Veza){//Veza moze da bude na pojmu jer ih tako povezuje
            //That
            Veza veza = (Veza) element;
            Pojam that = veza.getFrom();

            return overlap(pojam, that);
        }
        //That
        Pojam that = (Pojam) element;//Neki pojam koji sada hocemo da dodamo

        return overlap(pojam, that);
    }

    private boolean overlap(Pojam pojam, Pojam that) {
        //Pojam
        int x = pojam.getPosition().x;
        int y = pojam.getPosition().y;
        int right = x + pojam.getDimension().width;
        int down = y + pojam.getDimension().height;

        //That
        int x2 = that.getPosition().x;
        int y2 = that.getPosition().y;
        int right2 = x2 + that.getDimension().width;
        int down2 = y2 + that.getDimension().height;

        //That zeli da se postavi na mesto gde vec postoji elipsa a to je nemoguce
        //(x i y) ili (x i dole) se gleda da li se tu nalazi
        if ((x <= x2 && x2 <= right) && ((y <= y2 && y2 <= down) || (y <= down2 && down2 <= down)))
            return true;
        if ((x <= right2 && right2 <= right) && (((y <= y2 && y2 <= down) || (y <= down2 && down2 <= down))))
            return true;
        return false;
    }


}
