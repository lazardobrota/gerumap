package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
import raf.dsw.gerumap.gui.swing.view.ColorFrame;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MainPanel;
import raf.dsw.gerumap.gui.swing.view.MindMapView;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.Pojam;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ChooseAction extends AbstractGerumapAction{

    @Override
    public void actionPerformed(ActionEvent e) {
        String stroke = ColorFrame.getInstance().getTfDebljinaLinije().getText();
        String name = ColorFrame.getInstance().getTfIspisanTekst().getText();
        if (stroke.matches("[0-9]") && name.matches("[a-zA-Z 0-9]+")) {

            MindMapView mindMapView = (MindMapView) MainPanel.getInstance().getTabsPanel().getSelectedComponent();
            if(mindMapView == null) {
                ColorFrame.getInstance().dispose();
                return;
            }
            for (Element element : mindMapView.getMapSelectionModel().getSelectedElements()) {
                element.setColor(ColorFrame.getInstance().getChBiranjeBoje().getColor().getRGB());
                element.setStroke(Integer.parseInt(stroke));
            }

            //Ako je samo jedan onda i ime moze da mu se doda
            if (mindMapView.getMapSelectionModel().getSelectedElements().size() == 1) {
                boolean t = false;
                //Ako vec postoji element sa tim imenom
                for (MapNode mapNode : mindMapView.getMindMap().getChildren()) {
                    Element element = (Element) mapNode;
                    if (element.getIme().equals(name)) {
                        t = true;
                        break;
                    }
                }

                if (t) {//Ako vec postoji element sa tim nazivom onda dodaj i broj imenu
                    String newName = name + mindMapView.getMindMap().getNumberingChildren();
                    nameRecursive(mindMapView, name, newName);
                }
                else {//Ako ne postoji element sa tim imenom onda nema potrebe za brojem
                    Pojam pojam = (Pojam) mindMapView.getMapSelectionModel().getSelectedElements().get(0);
                    pojam.setIme(name);
                    pojam.setDimension(new Dimension(50 + ColorFrame.getInstance().getTfIspisanTekst().getText().length() * 10, 50));
                }
            }

            ColorFrame.getInstance().dispose();
            return;
        }

        ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.INVALID_TEXT);
    }

    //rekurzivno postavlja ime dok ne nadje neko koje niko nema
    private void nameRecursive(MindMapView mindMapView, String name, String newName) {
        boolean t = false;
        //Ako vec postoji element sa tim imenom
        for (MapNode mapNode : mindMapView.getMindMap().getChildren()) {
            Element element = (Element) mapNode;
            //Ako vec ima neki element sa tim imenom
            if (element.getIme().equals(newName)) {
                t = true;
                break;
            }
        }

        if (t) {//Ako vec postoji element sa tim nazivom onda dodaj i broj imenu
            newName = name + mindMapView.getMindMap().getNumberingChildren();
            nameRecursive(mindMapView, name, newName);
        }
        else {//Postavlja to ime
            Pojam pojam = (Pojam) mindMapView.getMapSelectionModel().getSelectedElements().get(0);
            pojam.setIme(name + mindMapView.getMindMap().getNumberingChildren());
            pojam.setDimension(new Dimension(50 + ColorFrame.getInstance().getTfIspisanTekst().getText().length() * 10, 50));
        }
    }
}
