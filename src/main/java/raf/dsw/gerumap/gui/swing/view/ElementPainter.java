package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.implementation.Element;

import java.awt.*;

@Getter
@Setter
public abstract class ElementPainter {

    private Element element;//element koji moze da bude ili pojam ili veza
    protected Shape shape;//Ima razlicite oblike, elipsa, pravougaonik, linija, ...

    public ElementPainter(Element element) {
        this.element = element;
    }

    public abstract void draw(Graphics2D g, Element element);
    public abstract boolean elementAt(Element element, Point position);
}
