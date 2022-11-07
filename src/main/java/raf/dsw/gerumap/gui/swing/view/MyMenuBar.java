package raf.dsw.gerumap.gui.swing.view;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {

    public MyMenuBar() {
        JMenu filemenu = new JMenu("File");//ono sto se pojavljuje gore
        filemenu.setMnemonic(KeyEvent.VK_F);//Koristi ALT i jos neki key(taster) da otvori File, u nasem slucaju ALT+F
        filemenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        filemenu.add(MainFrame.getInstance().getActionManager().getDeleteChildAction());
        filemenu.add(MainFrame.getInstance().getActionManager().getInfoAction());

        this.add(filemenu);

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.add(MainFrame.getInstance().getActionManager().getEditAction());

        this.add(helpMenu);
    }
}
