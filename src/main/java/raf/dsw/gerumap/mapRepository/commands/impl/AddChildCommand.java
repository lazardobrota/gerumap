package raf.dsw.gerumap.mapRepository.commands.impl;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;

public class AddChildCommand implements AbstractCommand {

    private MapTreeItem parent;
    private MapTreeItem child;

    public AddChildCommand(MapTreeItem parent, MapTreeItem child) {
        this.parent = parent;
        this.child = child;
    }
    @Override
    public void doCommand() {
        if(child == null ||  parent==null)
            return;

        parent.add(child);
        ((MapNodeComposite) parent.getMapNode()).addChild(child.getMapNode());
    }

    @Override
    public void undoCommand() {
        if(child == null ||  parent==null)
            return;

        child.removeFromParent();
        ((MapNodeComposite)(parent.getMapNode())).deleteChild(child.getMapNode());
    }
}
