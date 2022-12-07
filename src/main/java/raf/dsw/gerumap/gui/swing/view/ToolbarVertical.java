package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;

public class ToolbarVertical extends JToolBar {

    public ToolbarVertical() {
        super(JToolBar.VERTICAL);
        setFloatable(false);

        this.add(MainFrame.getInstance().getActionManager().getAddElementAction());
        this.addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getConnectAction());
        this.addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getEraseAction());
        this.addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getMoveAction());
        this.addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getSelectAction());
        this.addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getZoomInAction());
        this.addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getZoomOutAction());
        this.addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getColorAction());
    }
}
