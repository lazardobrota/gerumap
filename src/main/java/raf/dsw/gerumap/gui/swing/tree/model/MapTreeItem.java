package raf.dsw.gerumap.gui.swing.tree.model;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import javax.swing.tree.DefaultMutableTreeNode;

@Getter
@Setter
public class MapTreeItem extends DefaultMutableTreeNode {

    private MapNode mapNode;

    public MapTreeItem(MapNode mapNode) {
        this.mapNode = mapNode;
    }

    @Override
    public String toString() {
        return this.mapNode.getIme();
    }

    public void setName(String name) {
        this.mapNode.setIme(name);
    }
}
