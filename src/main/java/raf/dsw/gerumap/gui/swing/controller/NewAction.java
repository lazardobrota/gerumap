package raf.dsw.gerumap.gui.swing.controller;


import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.factory.FactoryUtils;
import raf.dsw.gerumap.mapRepository.factory.NodeFactory;

import java.awt.event.ActionEvent;

@Getter
@Setter
public class NewAction extends AbstractGerumapAction{



    private NodeFactory nodeFactory;


    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getMapTree().getSelectedNode() instanceof MapTreeItem){
            nodeFactory =
                    FactoryUtils.getFactory(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode());
        }
    }
}
