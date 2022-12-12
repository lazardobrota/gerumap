package raf.dsw.gerumap.gui.swing.state.concrate;

import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.geom.Point2D;

public class ZoomInState extends State {


    @Override
    public void pressed(int x, int y, MindMapView m) {

        //Ne moze vise od ovoga da zumira
        if (m.getZoom() >= 2) {
            return;
        }

        Point2D oldPoint2D = new Point2D.Double(m.getWidth()/2, m.getHeight()/2);
        m.transformToUserSpace(oldPoint2D);

        m.setZoom(m.getZoom() + 0.25);//Cetvrtina se dodaje
        m.setupTranformation();

        Point2D newPoint2D = new Point2D.Double(m.getWidth()/2, m.getHeight()/2);
        m.transformToUserSpace(newPoint2D);

        m.setTranslateX(m.getTranslateX() + newPoint2D.getX() - oldPoint2D.getX());
        m.setTranslateY(m.getTranslateY() + newPoint2D.getY() - oldPoint2D.getY());

        m.setupTranformation();
        m.repaint();
        System.out.println("Zoom");
    }
}
