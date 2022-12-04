package raf.dsw.gerumap.state.concrate;

import raf.dsw.gerumap.gui.swing.view.*;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.Veza;
import raf.dsw.gerumap.state.State;

import java.awt.*;

public class ConnectState extends State {
    int hitbox = 10;

    //todo treba vezi roditelj da se doda, ime i roditelji dete || takodje vezi trenutno from i to pojam moze da bude skroz isti pojam
    @Override
    public void pressed(int x, int y, MindMapView m) {

        //Lazni pojam koji koristimo samo za testiranje
        Veza veza = new Veza(new Pojam(new Dimension(hitbox, hitbox), new Point(x, y)));

        boolean t = false;
        Pojam pojam = null;
        for (ElementPainter elementPainter : m.getElementPainterList()) {
            if (elementPainter instanceof PojamPainter && elementPainter.elementAt(veza.getFrom(), veza.getFrom().getPosition())) {
                t = true;
                pojam = (Pojam) elementPainter.getElement();
                break;
            }
        }

        if (!t)
            return;

        veza.setFrom(pojam);
        m.getElementPainterList().add(new VezaPainter(veza));//Uvek je poslednji dodat u listu
        //System.out.println("Connect");
    }

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

        //Nova veza sa prvim elementom i hitbox za drugi
        Veza vezaEnd = new Veza(veza.getFrom(), new Pojam(new Dimension(hitbox, hitbox), new Point(x, y)));

        //Brisemo staru vezu sa jednim elementom
        m.getElementPainterList().remove(m.getElementPainterList().size() - 1);

        boolean t = false;
        Pojam pojam = null;
        for (ElementPainter painter : m.getElementPainterList()) {
            if (painter instanceof PojamPainter && painter.elementAt(vezaEnd.getTo(), vezaEnd.getTo().getPosition())) {
                t = true;
                pojam = (Pojam) painter.getElement();
                break;
            }
        }

        if (!t)
            return;

        veza.setTo(pojam);
        m.getElementPainterList().add(new VezaPainter(veza));
        System.out.println("Connect");
    }

    @Override
    public void dragged(int x, int y, MindMapView m) {
        if (m.getElementPainterList().isEmpty())
            return;

        ElementPainter elementPainter = m.getElementPainterList().get(m.getElementPainterList().size() - 1);
        if (elementPainter instanceof PojamPainter)
            return;

        //Uzima poslednji element koji je sigurno veza
        VezaPainter vezaPainter = (VezaPainter) elementPainter;
        Veza veza = (Veza) vezaPainter.getElement();

        //Nova veza sa prvim elementom i hitbox za drugi
        Veza vezaEnd = new Veza(veza.getFrom(), new Pojam(new Dimension(hitbox, hitbox), new Point(x, y)));

        vezaEnd.setColor(ColorFrame.getInstance().getChBiranjeBoje().getColor()); //dodajemo vezi boju
        vezaEnd.setStroke(Integer.parseInt(ColorFrame.getInstance().getTfDebljinaLinije().getText())); // //dodajemo vezi debljinu linije

        //Brisemo staru vezu sa jednim elementom
        m.getElementPainterList().remove(m.getElementPainterList().size() - 1);
        //Dodaje istu vezu samo na drugom mestu je kraj
        m.getElementPainterList().add(new VezaPainter(vezaEnd));
    }
}
