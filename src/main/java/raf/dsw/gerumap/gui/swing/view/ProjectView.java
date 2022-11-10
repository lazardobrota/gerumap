package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.observer.Subscriber;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class ProjectView extends JPanel implements Subscriber {


    private Project project = null;

    private FlowLayout flowLayout;

    private JLabel lblProjectName;

    public ProjectView() {
        init();
    }

    private void init() {
        flowLayout = new FlowLayout();
        lblProjectName = new JLabel(" ");

        flowLayout.setAlignment(FlowLayout.LEFT);
        this.setLayout(flowLayout);
        this.add(lblProjectName);
    }

    private void setViewUI() {
        this.lblProjectName.setText(this.project.toString());
        MainFrame.getInstance().getMapView().changeMindMaps(this.project);
    }

    @Override
    public void update(Object notification) {
        if (notification instanceof Project) {
            lblProjectName.setText(notification.toString());
        }
    }

    @Override
    public void rename(Object notification) {
        if (notification instanceof Project) {
            lblProjectName.setText(notification.toString());
        }
        if (notification instanceof MindMap) {

        }
    }

    public void setProject(Project project) {
        if (this.project != null)
            this.project.removeSubs(this);//brise sa prethodnog projekta da mu sub bude ProjectView iz MainFrame
        this.project = project;
        this.project.addSubs(this);//postavlja da mu sada selektovani projekat ima sub ProjectView iz MainFrame
        this.setViewUI();
    }
}
