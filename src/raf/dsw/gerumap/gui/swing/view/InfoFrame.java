package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InfoFrame extends JDialog {

    private static InfoFrame instance;

    private BoxLayout blhStudent1;
    private BoxLayout blhStudent2;
    private BoxLayout blhDugme;

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


        lblInfoStudenta1 = new JLabel("Lazar Dobrota RN74/21");
        lblInfoStudenta2 = new JLabel("Ana Sakotic RN68/21");

        JButton btnOk = new JButton("Ok");

        //Pravimo panel i dodajemo ga na JDialog
        JPanel panel = new JPanel();
        //panel.setBackground(Color.YELLOW);//todo skloni ovo
        this.add(panel, BorderLayout.NORTH);
        this.add(btnOk, BorderLayout.SOUTH);

        //TODO: Dodaj slike i raspodeli lepo komponente

        //Dodajemo layout za panel
        BoxLayout blVertikalan = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(blVertikalan);
        panel.setBorder(new EmptyBorder(50, 20, 0, 0));

        //Dodajemo komponente u panel
        panel.add(lblInfoStudenta1);
        panel.add(lblInfoStudenta2);
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
