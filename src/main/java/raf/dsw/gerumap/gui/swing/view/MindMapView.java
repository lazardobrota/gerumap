package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.observer.Subscriber;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.workspace.MapSelectionModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MindMapView extends JPanel implements Subscriber {

    private MindMap mindMap;
    private MapSelectionModel mapSelectionModel;
    private transient List<ElementPainter> elementPainterList = new ArrayList<>();//lista paintera
    private AffineTransform affineTransform;
    private double zoom = 1;

    public MindMapView(MindMap mindMap) {
        this.mindMap = mindMap;
        mapSelectionModel = new MapSelectionModel();
        initMMV();
    }

    private void initMMV() {
        this.setBackground(Color.WHITE);
        MouseController mouseController = new MouseController();
        this.addMouseListener(mouseController);
        this.addMouseMotionListener(mouseController);

        affineTransform = new AffineTransform();
    }

    @Override
    protected void paintComponent(Graphics g) {//Iscrtava
        super.paintComponent(g);//prvo iscrta sve tabove

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.transform(this.affineTransform);

        //sada nove dodate stvari iz paintera crta
        for (ElementPainter elementPainter : elementPainterList) {
            elementPainter.draw((Graphics2D) g, elementPainter.getElement());
            if (this.getMapSelectionModel().getSelectedElements().contains(elementPainter.getElement())) {
                elementPainter.selectedDraw((Graphics2D) g, elementPainter.getElement());
            }
        }

        if (this.mapSelectionModel.getFakePojam() != null) {
            ElementPainter elementPainter = new PojamPainter(this.mapSelectionModel.getFakePojam());
            elementPainter.selectedDraw((Graphics2D) g, elementPainter.getElement());
        }
    }

    public void setupTranformation() {
        this.affineTransform.setToIdentity();
        this.affineTransform.scale(this.zoom, this.zoom);
        for (ElementPainter elementPainter : this.getElementPainterList()) {
            elementPainter.getElement().setZoom(this.zoom);
        }
    }

    @Override
    public void update(Object notification) {
        //dodaj je novi element u mindmap pa da se doda i u painter, mora i uslov ako vec dodat
        if (notification instanceof MindMap) {
            MindMap mindMap = (MindMap) notification;
            if (mindMap.getChildren().size() > this.getElementPainterList().size()) {//Za dodavanje elemnta u paintere
                addElement(mindMap);
            }
            else if (mindMap.getChildren().size() < this.getElementPainterList().size()) {//Za brisanje elementa iz paintera
                removeElement(mindMap);
            }
        }
        repaint();//poziva paintComponent
    }

    public void addAllElements(MindMap mindMap) {
        //Prolazimo kroz svu decu mape uma
        for (MapNode mn : mindMap.getChildren()) {
            Element element = (Element) mn;
            if (element.getSubscribers() != null)
                element.getSubscribers().clear();//Obrise sve prethodne subove ako ih ima
            element.addSubs(this);
            if (element instanceof Pojam) {
                this.getElementPainterList().add(new PojamPainter(element));//Za pojam painter
            }
            else {
                this.getElementPainterList().add(new VezaPainter(element));//Za vezu painter
            }
        }
    }

    public void addElement(MindMap mindMap) {
        //Uzimamo poslednji mindMap koji je dodat
        Element element = (Element) mindMap.getChildren().get(mindMap.getChildren().size() - 1);
        element.addSubs(this);

        if (element instanceof Pojam)
            this.getElementPainterList().add(new PojamPainter(element));
        else
            this.getElementPainterList().add(new VezaPainter(element));
    }


    private void removeElement(MindMap mindMap) {
        boolean t;
        //Prolazimo kroz sve painter
        for (int i = 0; i < this.getElementPainterList().size(); i++) {
            t = false;
            //Prolazimo kroz sve elemente u notify mapi uma
            for (MapNode mapNode : mindMap.getChildren()) {
                Element element = (Element) mapNode;
                if (this.getElementPainterList().get(i).getElement().equals(element))
                    t = true;
            }
            if (t)
                continue;

            this.getElementPainterList().remove(i);
            this.getMapSelectionModel().getSelectedElements().clear();//Brise iz selektovanih elementa ako postoji tamo

            return;
        }
    }

    //Kad se klikne negde na mindMap prozor
    private class MouseController extends MouseAdapter {


        @Override
        public void mousePressed(MouseEvent e) {

            //Uzima mapu uma koja je trenutno prikazana na tabu
            MindMapView mindMapView = (MindMapView) MainPanel.getInstance().getTabsPanel().getSelectedComponent();
            Point position = e.getPoint();

            MainFrame.getInstance().getProjectView().pressedMouse(position.x, position.y, mindMapView);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Point position = e.getPoint();

            MindMapView mindMapView = (MindMapView) MainPanel.getInstance().getTabsPanel().getSelectedComponent();

            MainFrame.getInstance().getProjectView().releasedMouse(position.x, position.y, mindMapView);
        }


        @Override
        public void mouseDragged(MouseEvent e) {
            Point position = e.getPoint();

            MindMapView mindMapView = (MindMapView) MainPanel.getInstance().getTabsPanel().getSelectedComponent();
            MainFrame.getInstance().getProjectView().draggedMouse(position.x, position.y, mindMapView);
        }
    }
}
