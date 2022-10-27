package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        this.setSize(screenWidth / 3, screenHeight / 3);
        this.setLocationRelativeTo(MainFrame.getInstance());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("Informacije studenata");

        lblInfoStudenta1 = new JLabel("Lazar Dobrota RN74/21");
        lblInfoStudenta2 = new JLabel("Ana Sakotic RN68/21");
        JButton btnOk = new JButton("Ok");

        //Postavlja glavni vertikalni layout
        BoxLayout blGlaviV = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);//Ovako bangavo se stavlja BoxLayout na prozor klase
        this.getContentPane().setLayout(blGlaviV);//Ovako bangavo se stavlja BoxLayout na prozor klase

        JPanel panelStudent1 = new JPanel();
        panelStudent1.setBorder(new EmptyBorder(30, 0, 0,0));
        panelStudent1.add(lblInfoStudenta1);

        JPanel panelStudent2 = new JPanel();
        panelStudent2.setBorder(new EmptyBorder(30, 0, 0,0));
        panelStudent2.add(lblInfoStudenta2);

        JPanel panelDonji = new JPanel();
        panelDonji.setBorder(new EmptyBorder(30, 0, 0,0));
        panelDonji.add(btnOk);

        //panele dodajemo u JDialog
        panelStudent1.setBackground(Color.YELLOW);//todo skloni ovo
        this.add(Box.createGlue());
        this.add(panelStudent1);
        this.add(panelStudent2);
        this.add(panelDonji);

        //TODO: Dodaj slike
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
