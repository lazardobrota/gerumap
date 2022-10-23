package raf.dsw.gerumap.gui.swing.controller;

import javax.swing.*;
import java.net.URL;

public abstract class AbstractGerumapAction extends AbstractAction {

    public Icon loadIcon(String fileName) {
        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        else {
            System.out.println("Resource not found: " + fileName);
        }

        return icon;
    }
}
