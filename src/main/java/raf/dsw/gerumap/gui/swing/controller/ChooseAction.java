package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
import raf.dsw.gerumap.gui.swing.view.ColorFrame;

import java.awt.event.ActionEvent;

public class ChooseAction extends AbstractGerumapAction{


    @Override
    public void actionPerformed(ActionEvent e) {

        String stroke = ColorFrame.getInstance().getTfDebljinaLinije().getText();
        String name = ColorFrame.getInstance().getTfIspisanTekst().getText();
        if (stroke.matches("[0-9]") && name.matches("[a-zA-Z 0-9]+")) {
            ColorFrame.getInstance().dispose();
            return;
        }

        ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.INVALID_TEXT);
    }
}
