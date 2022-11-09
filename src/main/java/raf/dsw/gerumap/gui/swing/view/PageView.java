package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.observer.Subscriber;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class PageView extends JPanel implements Subscriber {

    private static PageView instance;

    private TabsPanel tabsPanel;

    private BorderLayout borderLayout;

    private PageView() {
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

    public static PageView getInstance() {
        if (instance == null) {
            instance = new PageView();
            instance.init();
        }

        return instance;
    }

    @Override
    public void update(Object notification) {

    }

    @Override
    public void projectRename(Object notification) {

    }
}
