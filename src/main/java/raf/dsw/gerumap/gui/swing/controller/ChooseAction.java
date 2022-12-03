package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.ColorFrame;

import java.awt.event.ActionEvent;

public class ChooseAction extends AbstractGerumapAction{


    @Override
    public void actionPerformed(ActionEvent e) {

        ColorFrame.getInstance().dispose();
    }
}
