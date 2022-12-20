package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.observer.Subscriber;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import raf.dsw.gerumap.gui.swing.state.StateManager;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class ProjectView extends JPanel implements Subscriber {


    private Project project = null;
    private FlowLayout flowLayout;
    private JLabel lblProjectName;

    private StateManager stateManager;

    public ProjectView() {
        init();
    }

    private void init() {
        flowLayout = new FlowLayout();
        lblProjectName = new JLabel(" ");
        stateManager = new StateManager();

        flowLayout.setAlignment(FlowLayout.LEFT);
        this.setLayout(flowLayout);
        this.add(lblProjectName);

    }

    private void setViewUI() {
        this.lblProjectName.setText(this.project.toString());
        ApplicationFramework.getInstance().getGui().getCommandManager().restartCommands();
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
            //Ako je broj tabova veci nego broj dece
            if (MainPanel.getInstance().getTabsPanel().getTabCount() > ((Project) notification).getChildren().size()) {
                MainPanel.getInstance().removeMap(project);
                return;
            }

            //Ako je promenjeno ime ili autor projekta
            if (!lblProjectName.getText().equals(notification.toString())) {
                lblProjectName.setText(notification.toString());
                return;
            }

            return;
        }

        if (notification instanceof MindMap) {
            //Ako je promenjeno ime mape uma
            MainPanel.getInstance().changeTabName((Project) ((MindMap) notification).getParent());
        }
    }


    public void setProject(Project project) {
        if (this.project != null) {
            this.project.removeSubs(this);//brise sa prethodnog projekta da mu sub bude ProjectView iz MainFrame
            //Sklanja za svaki mindMap sa starog projekta ProjectView kao sub
            for (MapNode mapNode : this.project.getChildren()) {
                mapNode.removeSubs(this);
            }
        }
        this.project = project;
        this.project.addSubs(this);//postavlja da mu sada selektovani projekat ima sub ProjectView iz MainFrame
        this.setViewUI();
    }

    public void startAddElementState() {
        this.stateManager.setAddElementState();
    }

    public void startConnectState() {
        this.stateManager.setConnectState();
    }

    public void startEraseState() {
        this.stateManager.setEraseState();
    }

    public void startMoveState() {
        this.stateManager.setMoveState();
    }

    public void startSelectState() {
        this.stateManager.setSelectState();
    }

    public void startZoomInState() {
        this.stateManager.setZoomInState();
    }

    public void startZoomOutState() {
        this.stateManager.setZoomOutState();
    }

    public void pressedMouse(int x, int y, MindMapView mindMapView) {
        this.stateManager.getCurrentState().pressed(x, y, mindMapView);
    }

    public void draggedMouse(int x, int y, MindMapView mindMapView) {
        this.stateManager.getCurrentState().dragged(x, y, mindMapView);
    }

    public void releasedMouse(int x, int y, MindMapView mindMapView) {
        this.stateManager.getCurrentState().released(x, y, mindMapView);
    }
}
