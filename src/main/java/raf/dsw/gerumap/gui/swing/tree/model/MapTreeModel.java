package raf.dsw.gerumap.gui.swing.tree.model;

import lombok.Getter;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
@Getter
public class MapTreeModel extends DefaultTreeModel {

    public MapTreeModel(TreeNode root) {
        super(root);
    }

    @Override
    public MapTreeItem getRoot() {
        MapTreeItem root = (MapTreeItem) super.getRoot();
        return root;
    }
}
