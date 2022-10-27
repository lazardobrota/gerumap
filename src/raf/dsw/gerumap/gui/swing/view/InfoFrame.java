package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class InfoFrame extends JDialog {

    private static InfoFrame instance;
    private JLabel lblInfoStudenta1;
    private JLabel lblInfoStudenta2;

    public InfoFrame() {
    }

    private void initialise() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = (int) screenSize.getHeight();
        int screenWidth = (int) screenSize.getWidth();
        this.setSize(screenWidth / 3, screenHeight / 2);
        this.setLocationRelativeTo(MainFrame.getInstance());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("Informacije studenata");

        JPanel panel = new JPanel();


        lblInfoStudenta1 = new JLabel("Lazar Dobrota RN74/21");
        lblInfoStudenta1 = new JLabel("Ana Sakotic RN68/21");
    }


    public static InfoFrame getInstance() {
        if (instance == null) {
            instance = new InfoFrame();
            instance.initialise();
        }

        return instance;
    }

    public static void setInstance(InfoFrame instance) {
        InfoFrame.instance = instance;
    }

    public JLabel getLblInfoStudenta1() {
        return lblInfoStudenta1;
    }

    public void setLblInfoStudenta1(JLabel lblInfoStudenta1) {
        this.lblInfoStudenta1 = lblInfoStudenta1;
    }

    public JLabel getLblInfoStudenta2() {
        return lblInfoStudenta2;
    }

    public void setLblInfoStudenta2(JLabel lblInfoStudenta2) {
        this.lblInfoStudenta2 = lblInfoStudenta2;
    }
}
