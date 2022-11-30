package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.observer.Subscriber;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MindMapView extends JPanel implements Subscriber {

    private MindMap mindMap;
    private List<ElementPainter> elementPainterList = new ArrayList<>();//todo da li on uzima svu decu od mindMap i kako to radi

    public MindMapView(MindMap mindMap) {
        this.mindMap = mindMap;
    }

    @Override
    public void update(Object notification) {

    }
}
