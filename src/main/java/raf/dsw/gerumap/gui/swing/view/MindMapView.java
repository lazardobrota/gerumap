package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.observer.Subscriber;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MindMapView extends JPanel implements Subscriber {

    private MindMap mindMap;
    private List<ElementPainter> elementPainterList = new ArrayList<>();//lista paintera

    public MindMapView(MindMap mindMap) {
        this.mindMap = mindMap;
        initMMV();
    }

    private void initMMV() {
        this.setBackground(Color.WHITE);
        MouseController mouseController = new MouseController();
        this.addMouseListener(mouseController);
        this.addMouseMotionListener(mouseController);
    }

    @Override
    protected void paintComponent(Graphics g) {//Iscrtava
        super.paintComponent(g);//prvo iscrta sve tabove

        //sada nove dodate stvari iz paintera crta
        for (ElementPainter elementPainter : elementPainterList) {
            elementPainter.draw((Graphics2D) g, elementPainter.getElement());
        }

    }

    @Override
    public void update(Object notification) {
        //treba da bude if ako je dodat novi element za repaint
        repaint();//poziva paintComponent
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
