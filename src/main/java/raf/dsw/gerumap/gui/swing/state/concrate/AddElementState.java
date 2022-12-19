package raf.dsw.gerumap.gui.swing.state.concrate;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
import raf.dsw.gerumap.gui.swing.state.State;
import raf.dsw.gerumap.gui.swing.view.ColorFrame;
import raf.dsw.gerumap.gui.swing.view.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.gui.swing.view.PojamPainter;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.commands.impl.AddElementCommand;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;

import java.awt.*;

public class AddElementState extends State {

    @Override
    public void pressed(int x, int y, MindMapView m) {
        m.getMapSelectionModel().getSelectedElements().clear();//Skloni selekt

        MindMap mindMap = m.getMindMap();
        int width = ColorFrame.getInstance().getTfIspisanTekst().getText().length(); // duzina elipse
        Dimension dimension = new Dimension(50 + width*10, 50); //Lazni pojam gde samo proveravamo da li postoji nesto na tim koordinatama
        int x2 = coordinate(x, dimension.width);
        int y2 = coordinate(y, dimension.height);
        Pojam pojam = new Pojam(dimension, new Point(Math.abs(x2), Math.abs(y2)));

        for (ElementPainter elementPainter : m.getElementPainterList()) {
            //Vec postoji na toj poziciji takav pojam
            if (elementPainter instanceof PojamPainter && elementPainter.elementAt(pojam, pojam.getPosition())) {
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.POSITION_TAKEN);
                return;
            }
        }

        String name = ColorFrame.getInstance().getTfIspisanTekst().getText();
        //Moze da se pravi pravi pojam jer ima slobodan prostor da se napravi
        pojam = new Pojam(name, mindMap, dimension, new Point(Math.abs(x2), Math.abs(y2)));
        pojam.addSubs(m);//Dodaje pojmu MindMapView kao sub //todo da li je ovo okej addsubs???
        pojam.setColor(ColorFrame.getInstance().getChBiranjeBoje().getColor());//uzima selektovanu boju za pojam
        String stroke = ColorFrame.getInstance().getTfDebljinaLinije().getText();
        pojam.setStroke(Integer.parseInt(stroke));

        AbstractCommand command = new AddElementCommand(m, pojam);
        ApplicationFramework.getInstance().getGui().getCommandManager().addCommand(command);
        System.out.println("Add");
    }

    private int coordinate(int c, int dimension) {
        int c2 = c - dimension / 2;

        //Ako je van panela i ide u minus
        if (c2 < 0)
            c2 = 0;

        return c2;
    }
}
