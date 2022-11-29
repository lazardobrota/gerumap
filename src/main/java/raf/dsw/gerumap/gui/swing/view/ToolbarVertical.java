package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;

public class ToolbarVertical extends JToolBar {

    public ToolbarVertical() {
        super(JToolBar.VERTICAL);
        setFloatable(false);

        this.add(MainFrame.getInstance().getActionManager().getAddElementAction());
        this.add(MainFrame.getInstance().getActionManager().getConnectAction());
        this.add(MainFrame.getInstance().getActionManager().getEraseAction());
        this.add(MainFrame.getInstance().getActionManager().getMoveAction());
        this.add(MainFrame.getInstance().getActionManager().getSelectAction());
        this.add(MainFrame.getInstance().getActionManager().getZoomAction());
    }
}
