package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.InfoFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class OkAction implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        InfoFrame.getInstance().dispose();
    }
}
