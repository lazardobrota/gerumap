package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;

public class Toolbar extends JToolBar {

    public Toolbar() {
        super(HORIZONTAL);
        setFloatable(false);//da li moze da se pomera

        this.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        this.add(MainFrame.getInstance().getActionManager().getDeleteChildAction());
        this.add(MainFrame.getInstance().getActionManager().getEditAction());
        this.add(MainFrame.getInstance().getActionManager().getInfoAction());


    }
}
