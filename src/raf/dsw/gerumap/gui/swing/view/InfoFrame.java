package raf.dsw.gerumap.gui.swing.view;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InfoFrame extends JDialog {

    private static InfoFrame instance;

    private JLabel lblInfoStudenta1;
    private JLabel lblSlikaStudenta1;
    private JLabel lblInfoStudenta2;
    private JLabel lblSlikaStudenta2;

    public InfoFrame() {
    }

    private void initialise() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = (int) screenSize.getHeight();
        int screenWidth = (int) screenSize.getWidth();
        this.setSize(screenWidth / 5 + 20, screenHeight / 2 - 50);
        this.setLocationRelativeTo(MainFrame.getInstance());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("Informacije studenata");

        lblInfoStudenta1 = new JLabel("Lazar Dobrota RN74/21");
        //InfoAction nasledjuje(extends) abstraktnu klasu AbstractGerumapAction koji u sebi ima vec metodu loadIcon
        lblSlikaStudenta1 = new JLabel(MainFrame.getInstance().getActionManager().getInfoAction().loadIcon("images/lazar.png"));
        lblInfoStudenta2 = new JLabel("Ana Sakotic RN68/21");
        lblSlikaStudenta2 = new JLabel(MainFrame.getInstance().getActionManager().getInfoAction().loadIcon("images/ana.png"));
        JButton btnOk = new JButton("Ok");//TODO: Nekako treba za dugme da se doda akcije da izadje iz pop up

        //Postavlja glavni vertikalni layout
        //Ovako bangavo se stavlja BoxLayout na prozor klase
        BoxLayout blGlaviV = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.getContentPane().setLayout(blGlaviV);

        //FlowLayout za studenta1
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.CENTER);
        flowLayout.setHgap(50);

        //FlowLayout za studenta2
        FlowLayout flowLayout2 = new FlowLayout();
        flowLayout2.setAlignment(FlowLayout.CENTER);
        flowLayout2.setHgap(60);

        JPanel panelStudent1 = new JPanel();
        panelStudent1.setLayout(flowLayout);
        panelStudent1.setBorder(new EmptyBorder(30, 0, 0,0));
        panelStudent1.add(lblInfoStudenta1);
        panelStudent1.add(lblSlikaStudenta1);

        JPanel panelStudent2 = new JPanel();
        panelStudent2.setLayout(flowLayout2);
        panelStudent2.setBorder(new EmptyBorder(30, 0, 0,0));
        panelStudent2.add(lblInfoStudenta2);
        panelStudent2.add(lblSlikaStudenta2);

        JPanel panelDonji = new JPanel();
        panelDonji.setBorder(new EmptyBorder(30, 0, 0,0));
        panelDonji.add(btnOk);

        //panele dodajemo u JDialog
        this.add(Box.createGlue());
        this.add(panelStudent1);
        this.add(panelStudent2);
        this.add(panelDonji);
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

    public JLabel getLblSlikaStudenta1() {
        return lblSlikaStudenta1;
    }

    public void setLblSlikaStudenta1(JLabel lblSlikaStudenta1) {
        this.lblSlikaStudenta1 = lblSlikaStudenta1;
    }

    public JLabel getLblSlikaStudenta2() {
        return lblSlikaStudenta2;
    }

    public void setLblSlikaStudenta2(JLabel lblSlikaStudenta2) {
        this.lblSlikaStudenta2 = lblSlikaStudenta2;
    }
}
