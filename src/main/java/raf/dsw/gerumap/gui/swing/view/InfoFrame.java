package raf.dsw.gerumap.gui.swing.view;


import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.controller.OkAction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Getter
@Setter
public class InfoFrame extends JDialog {

    private static InfoFrame instance;

    private JLabel lblInfoStudenta1;
    private JLabel lblSlikaStudenta1;
    private JLabel lblInfoStudenta2;
    private JLabel lblSlikaStudenta2;

    private InfoFrame() {
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
        lblSlikaStudenta1 = new JLabel(MainFrame.getInstance().getActionManager().getInfoAction().loadIcon("/images/lazar.png"));
        lblInfoStudenta2 = new JLabel("Ana Sakotic RN68/21");
        lblSlikaStudenta2 = new JLabel(MainFrame.getInstance().getActionManager().getInfoAction().loadIcon("/images/ana.png"));
        JButton btnOk = new JButton("Ok");
        btnOk.addActionListener(MainFrame.getInstance().getActionManager().getOkAction());

        //Postavlja glavni vertikalni layout
        //Ovako bangavo se stavlja BoxLayout na prozor klase
        BoxLayout blGlavniV = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.getContentPane().setLayout(blGlavniV);

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


}
