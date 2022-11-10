package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.observer.Subscriber;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MapView extends JPanel implements Subscriber {


    private TabsPanel tabsPanel;

    private BorderLayout borderLayout;

    public MapView() {
        init();
    }

    private void init() {
        tabsPanel = new TabsPanel();
        tabsPanel.add("tab1", new JLabel(" "));
        tabsPanel.add("tab2", new JLabel(" "));
        tabsPanel.add("tab3", new JLabel(" "));

        borderLayout = new BorderLayout();

        this.setLayout(borderLayout);
        this.add(tabsPanel, BorderLayout.CENTER);
    }

    public void changeMindMaps(Project project) {
        tabsPanel.removeAll();
        for (MapNode mapNode : project.getChildren()) {
            MindMap mindMap = (MindMap) mapNode;
            tabsPanel.add(mindMap.toString(), new JLabel());//TODO: Ovde ne znam sta umesto JLabel da stavim
        }
    }


    @Override
    public void update(Object notification) {
        if (notification instanceof MindMap) {
        }
    }

    @Override
    public void rename(Object notification) {

    }
}
