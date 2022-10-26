package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {

    public MyMenuBar() {
        JMenu filemenu = new JMenu("File");//ono sto se pojavljuje gore
        filemenu.setMnemonic(KeyEvent.VK_F);//Koristi ALT i jos neki key(taster) da otvori File, u nasem slucaju ALT+F
        filemenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        filemenu.add(MainFrame.getInstance().getActionManager().getExitAction());


        this.add(filemenu);
    }
}
