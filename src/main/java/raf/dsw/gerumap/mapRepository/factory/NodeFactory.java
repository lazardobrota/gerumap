package raf.dsw.gerumap.mapRepository.factory;


import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;

public abstract class NodeFactory {

     public MapNode getNode(){

          MapNode node = createNode();
          node.setParent(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode());
          node.setIme(node.getIme() + ((MapNodeComposite)(node.getParent())).getNumberingChildren());

          return node;
     }

     public abstract MapNode createNode();
}
