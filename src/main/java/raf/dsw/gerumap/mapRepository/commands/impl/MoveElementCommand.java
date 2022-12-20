package raf.dsw.gerumap.mapRepository.commands.impl;

import raf.dsw.gerumap.gui.swing.state.concrate.MoveState;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoveElementCommand implements AbstractCommand {
    private MindMap mindMap;
    private List<Pojam> pojamList = new ArrayList<>();
    private Point originalPoint;
    private Point lastPoint;
    private boolean flag = false;


    public MoveElementCommand(MindMap mindMap, List<Pojam> pojamList, Point originalPoint, Point lastPoint) {
        this.mindMap = mindMap;
        this.pojamList.addAll(pojamList);
        this.originalPoint = originalPoint;
        this.lastPoint = lastPoint;
    }

    @Override
    public void doCommand() {
        if(pojamList == null || mindMap == null)
            return;

        if (!flag)//Da se ne bi vracali pojmovi na stare pozicije kada se prvi put pravi komanda u mouseReleased
            return;

        for (Pojam pojam : pojamList) {
            int px = pojam.getPosition().x + (lastPoint.x - originalPoint.x);
            int py = pojam.getPosition().y + (lastPoint.y - originalPoint.y);
            pojam.setPosition(new Point(px, py));
        }
    }

    @Override
    public void undoCommand() { //Vraca na originalnu poziciju

        for (Pojam pojam : pojamList) {
            int px = pojam.getPosition().x - (lastPoint.x - originalPoint.x);
            int py = pojam.getPosition().y - (lastPoint.y - originalPoint.y);
            pojam.setPosition(new Point(px, py));
        }
        flag = true;//Kada je uradjen undo sada je dozvoljen redo da se radi
    }
}
