package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.observer.Subscriber;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

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
        MainPanel.getInstance().changeMindMaps(this.project);
    }

    private void removeProject(ProjectExplorer projectExplorer) {

        for (MapNode mapNode : projectExplorer.getChildren()) {
            Project project = (Project) mapNode;
            if (lblProjectName.getText().equals(project.toString()))
                return;
        }

        MainPanel.getInstance().getTabsPanel().removeAll();
        lblProjectName.setText(" ");
        project = null;

    }

    @Override
    public void update(Object notification) {
        if (notification instanceof ProjectExplorer) {
            this.removeProject((ProjectExplorer) notification);
            return;
        }

        if (notification instanceof Project) {
            //Ako ima vise dece nego tabova
            if (MainPanel.getInstance().getTabsPanel().getTabCount() < ((Project) notification).getChildren().size()) {
                MainPanel.getInstance().addMap(project);
                return;
            }
            //Ako jebroj tabova veci nego broj dece
            if (MainPanel.getInstance().getTabsPanel().getTabCount() > ((Project) notification).getChildren().size()) {
                MainPanel.getInstance().removeMap(project);
                return;
            }

            //Ako je promeneno ime ili autor projekta
            if (!lblProjectName.getText().equals(notification.toString())) {
                lblProjectName.setText(notification.toString());
                return;
            }

            //Ako je promenjeno ime mape uma
            MainPanel.getInstance().changeTabName((Project) notification);
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
