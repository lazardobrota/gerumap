package raf.dsw.gerumap.gui.swing.tree.view;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class MapTreeCellRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        URL imageURL = null;
        //TODO: Dodaj slike
        if (((MapTreeItem)value).getMapNode() instanceof ProjectExplorer) {
            imageURL = this.getClass().getResource("/images/projectexplorer.ico");
        }
        else if (((MapTreeItem)value).getMapNode() instanceof Project) {
            imageURL = this.getClass().getResource("/images/project.jpg");
        }
        else if (((MapTreeItem)value).getMapNode() instanceof MindMap) {
            imageURL = this.getClass().getResource("/images/mindmap.jpg");
        }
        else if (((MapTreeItem)value).getMapNode() instanceof Element) {
            imageURL = this.getClass().getResource("/images/element.png");
        }

        Icon icon = null;
        if (imageURL != null)
            icon = new ImageIcon(imageURL);
        this.setIcon(icon);

        return this;
    }
}
