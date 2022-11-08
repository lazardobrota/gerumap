package raf.dsw.gerumap.mapRepository.factory;


import raf.dsw.gerumap.mapRepository.composite.MapNode;

public abstract class NodeFactory extends MapNode {

     public NodeFactory(String ime, MapNode parent) {
          super(ime, parent);
     }

     public MapNode getNode(){
          MapNode node = createNode();
          // node.setIme();
          //node.setParent();
          return node;
     }

     public abstract MapNode createNode();
}
