package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
import raf.dsw.gerumap.gui.swing.view.MainPanel;
import raf.dsw.gerumap.gui.swing.view.MindMapView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExportImageAction extends AbstractGerumapAction{

    private static int counter = 1;

    public ExportImageAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,loadIcon("/images/export.png"));
        putValue(NAME,"Delete");
        putValue(SHORT_DESCRIPTION,"Izbrisi dete u stablu");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MindMapView mindMapView = (MindMapView) MainPanel.getInstance().getTabsPanel().getSelectedComponent();
        if (mindMapView == null) {//Nista nije selektovano
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ERROR, ProblemType.NOTHING_IS_SELECTED);
            return;
        }

        BufferedImage image = new BufferedImage(mindMapView.getWidth(), mindMapView.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        mindMapView.printAll(g);
        g.dispose();
        try {
            ImageIO.write(image, "png", new File(  "src\\main\\resources\\Pictures\\picture.png"));
            //ImageIO.write(image, "png", new File(  "src\\main\\resources\\Pictures\\picture" + (counter++) + ".png"));// ako zelimo vise slika da imamo
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
}
