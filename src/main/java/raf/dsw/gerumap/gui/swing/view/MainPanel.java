package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MainPanel extends JPanel{

    private static MainPanel instance;

    private TabsPanel tabsPanel;

    private BorderLayout borderLayout;

    private MainPanel() {
    }

    private void init() {
        tabsPanel = new TabsPanel();
        tabsPanel.addTab("tab1", new JLabel(" "));
        tabsPanel.addTab("tab2", new JLabel(" "));
        tabsPanel.addTab("tab3", new JLabel(" "));

        borderLayout = new BorderLayout();

        this.setLayout(borderLayout);
        this.add(tabsPanel, BorderLayout.CENTER);
    }

    public void changeMindMaps(Project project) {
        tabsPanel.removeAll();
        for (MapNode mapNode : project.getChildren()) {
            MindMap map = (MindMap) mapNode;
            tabsPanel.add(map.toString(), new JLabel());//TODO: Ovde ne znam sta umesto JLabel da stavim
        }
    }

    public static MainPanel getInstance() {
        if (instance == null) {
            instance = new MainPanel();
            instance.init();
        }
        return instance;
    }
}
