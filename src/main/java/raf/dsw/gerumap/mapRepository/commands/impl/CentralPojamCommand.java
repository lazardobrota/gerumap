package raf.dsw.gerumap.mapRepository.commands.impl;

import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;

import java.awt.*;

public class CentralPojamCommand implements AbstractCommand {

    Pojam pojam;
    Point oldPosition;
    Point newPositon;
    int oldStroke;
    int oldColor;

    public CentralPojamCommand(Pojam pojam, Point oldPosition, Point newPositon) {
        this.pojam = pojam;
        this.oldPosition = oldPosition;
        this.newPositon = newPositon;
        this.oldStroke = pojam.getStroke();
        this.oldColor = pojam.getColor();
    }

    @Override
    public void doCommand() {
        pojam.setStroke(10);//debljina
        pojam.setColor(-16777216);//Crna boja
        pojam.setPosition(newPositon);
    }

    @Override
    public void undoCommand() {
        pojam.setStroke(oldStroke);
        pojam.setColor(oldColor);
        pojam.setPosition(oldPosition);
    }
}
