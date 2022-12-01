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
        this.addMouseListener(new MouseController());
    }

    //todo
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void update(Object notification) {
    }

    private class MouseController extends MouseAdapter {

        //Uzima iz selektovanog taba minMapView odnosno JPanel
        private MindMapView mindMapView = (MindMapView) MainPanel.getInstance().getTabsPanel().getSelectedComponent();

        @Override
        public void mousePressed(MouseEvent e) {
            Point position = e.getPoint();
            MainFrame.getInstance().getProjectView().pressedMouse(position.x, position.y, mindMapView);
        }

        //todo
        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
        }

        //todo
        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
        }
    }
}
