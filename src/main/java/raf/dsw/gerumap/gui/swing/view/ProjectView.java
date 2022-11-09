package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.observer.Subscriber;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class ProjectView extends JPanel implements Subscriber {

    private static ProjectView instance = null;

    private MapNode mapNode = null;

    private FlowLayout flowLayout;

    private JLabel lblProjectName;

    private ProjectView() {
    }

    private void init() {
        flowLayout = new FlowLayout();
        lblProjectName = new JLabel(" ");

        flowLayout.setAlignment(FlowLayout.LEFT);
        this.setLayout(flowLayout);
        this.add(lblProjectName);
    }

    public static ProjectView getInstance() {
        if (instance == null) {
            instance = new ProjectView();
            instance.init();
        }

        return instance;
    }

    @Override
    public void update(Object notification) {
        if (notification instanceof Project) {
            lblProjectName.setText(notification.toString());
        }
    }

    @Override
    public void projectRename(Object notification) {
        if (notification instanceof Project) {
            lblProjectName.setText(notification.toString());
        }
    }
}
