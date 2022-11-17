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
        borderLayout = new BorderLayout();

        this.setLayout(borderLayout);
        this.add(tabsPanel, BorderLayout.CENTER);
    }

    public void changeMindMaps(Project project) {
        tabsPanel.removeAll();
        for (MapNode mapNode : project.getChildren()) {
            MindMap map = (MindMap) mapNode;
            map.addSubs(MainFrame.getInstance().getProjectView());
            tabsPanel.add(map.getIme(), new JPanel());
        }
    }

    //Menja ime mape uma na tabu
    public void changeTabName(Project project) {
        boolean t = false;
        //Prolazimo kroz sve tabove
        for (int i = 0; i < tabsPanel.getTabCount(); i++) {
            t = false;
            //Prolazimo kroz sve mape uma u projektu
            for (MapNode mapNode : project.getChildren()) {
                MindMap mindMap = (MindMap) mapNode;
                //Ako postoji ta mapa uma u projektu sa istim imenom kao i na tabu onda ne radi nista
                if (tabsPanel.getTitleAt(i).equals(mindMap.getIme()))
                    t = true;
            }
            if (t)
                continue;

            tabsPanel.setTitleAt(i, project.getChildren().get(i).getIme());
            return;
        }
    }

    public void addMap(Project project) {
        //Uzimamo poslednji mindMap koji je dodat
        MindMap mindMap = (MindMap) project.getChildren().get(project.getChildren().size() - 1);
        mindMap.addSubs(MainFrame.getInstance().getProjectView());
        tabsPanel.addTab(mindMap.getIme(), new JPanel());
    }

    public void removeMap(Project project) {
        boolean t = false;
        //Prolazimo kroz sve tabove
        for (int i = 0; i < tabsPanel.getTabCount(); i++) {
            t = false;
            //Prolazimo kroz sve mape uma u projektu
            for (MapNode mapNode : project.getChildren()) {
                MindMap mindMap = (MindMap) mapNode;
                //Ako postoji ta mapa uma u projektu i na tabu onda se ne brise
                if (tabsPanel.getTitleAt(i).equals(mindMap.getIme()))
                    t = true;
            }
            if (t)
                continue;

            tabsPanel.removeTabAt(i);
            return;
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
