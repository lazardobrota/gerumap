package raf.dsw.gerumap.state.concrate;

import raf.dsw.gerumap.gui.swing.view.*;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.Veza;
import raf.dsw.gerumap.state.State;

import java.awt.*;

public class ConnectState extends State {
    int hitbox = 10;

    //todo vezi trenutno from i to pojam moze da bude skroz isti pojam
    @Override
    public void pressed(int x, int y, MindMapView m) {

        //Lazni pojam koji koristimo samo za testiranje
        Veza veza = new Veza(new Pojam(new Dimension(hitbox, hitbox), new Point(x, y)));
        veza.addSubs(m);//Dodaje vezi MindMapView kao sub

        boolean t = false;
        Pojam pojam = null;
        for (ElementPainter elementPainter : m.getElementPainterList()) {
            if (elementPainter instanceof PojamPainter && elementPainter.elementAt(veza.getFrom(), veza.getFrom().getPosition())) {
                t = true;
                pojam = (Pojam) elementPainter.getElement();
                break;
            }
        }

        m.getElementPainterList().add(new VezaPainter(veza));//Uvek je poslednji dodat u listu

        if (!t) //Vraca fake vezu koju na kraju brisemo
            return;

        veza.setFrom(pojam);
        //System.out.println("Connect");
    }

    //todo ne mogu duple veze sa iste stvari
    @Override
    public void released(int x, int y, MindMapView m) {

        if (m.getElementPainterList().isEmpty())
            return;

        ElementPainter elementPainter = m.getElementPainterList().get(m.getElementPainterList().size() - 1);
        if (elementPainter instanceof PojamPainter)
            return;

        //Uzima poslednji element koji je sigurno veza
        VezaPainter vezaPainter = (VezaPainter) elementPainter;
        Veza veza = (Veza) vezaPainter.getElement();

        //Mora da se doda jer ako nikada nije pozvan dragg izbacuje nullPointerExcepiton
        veza.setTo(new Pojam(new Dimension(hitbox, hitbox), new Point(x, y)));

        boolean t = false;
        Pojam pojam = null;
        for (ElementPainter painter : m.getElementPainterList()) {
            if (painter instanceof PojamPainter && painter.elementAt(veza.getTo(), veza.getTo().getPosition())) {
                t = true;
                pojam = (Pojam) painter.getElement();
                break;
            }
        }

        //Ako nije pronasao drugi pojam ili je pocetni pojam los i ima i dalje hitbox za dimenzije
        if (!t || veza.getFrom().getDimension().width == hitbox) {
            //Brisemo staru vezu sa jednim elementom
            m.getElementPainterList().remove(m.getElementPainterList().size() - 1);
            veza.setIme("Fake");
            return;
        }

        veza.setTo(pojam);//poziva observer
        veza = new Veza("Veza" + m.getMindMap().getNumberingChildren(), m.getMindMap(), veza.getFrom(), veza.getTo());
        m.getMindMap().addChild(veza);//Dobra je veza i dodaje se u decu mape uma
        System.out.println("Connect");
    }

    @Override
    public void dragged(int x, int y, MindMapView m) {
        if (m.getElementPainterList().isEmpty())
            return;

        //Uzima poslednji element
        ElementPainter elementPainter = m.getElementPainterList().get(m.getElementPainterList().size() - 1);
        if (elementPainter instanceof PojamPainter)
            return;

        //Uzima poslednji element koji je sigurno veza
        VezaPainter vezaPainter = (VezaPainter) elementPainter;
        Veza veza = (Veza) vezaPainter.getElement();

        //Nova veza sa prvim elementom i hitbox za drugi
        veza.setTo(new Pojam(new Dimension(hitbox, hitbox), new Point(x, y)));

        //poziva observer
        veza.setColor(ColorFrame.getInstance().getChBiranjeBoje().getColor()); //dodajemo vezi boju
        veza.setStroke(Integer.parseInt(ColorFrame.getInstance().getTfDebljinaLinije().getText())); // //dodajemo vezi debljinu linije
    }
}
