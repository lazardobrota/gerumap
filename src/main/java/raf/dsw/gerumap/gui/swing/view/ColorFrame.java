package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.controller.ActionManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Getter
@Setter
public class ColorFrame extends JDialog {

    private static ColorFrame instance = null;
    private JLabel lblIspisanTekst;
    private JTextField tfIspisanTekst;
    private JLabel lblDebljinaLinije;
    private JTextField tfDebljinaLinije;
    private JColorChooser chBiranjeBoje;
    private JButton btnIzaberi;

    private ColorFrame(){}

    private void init(){
        this.setModalityType(ModalityType.APPLICATION_MODAL);//Postavi da ne moze nista drugo da se radi dok se ne zatvori JDialog
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = (int) screenSize.getHeight();
        int screenWidth = (int) screenSize.getWidth();
        this.setSize(screenWidth / 2, screenHeight / 2);
        this.setLocationRelativeTo(MainFrame.getInstance());
        this.addWindowListener(MainFrame.getInstance().getActionManager().getClosingColorAction());
        //this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("Izaberite kako izgleda vaš oblik");


        lblIspisanTekst = new JLabel("Uneti tekst");
        tfIspisanTekst = new JTextField();
        tfIspisanTekst.setPreferredSize(new Dimension(70,20));
        lblDebljinaLinije = new JLabel("Uneti debljinu linije");
        tfDebljinaLinije = new JTextField();
        tfDebljinaLinije.setPreferredSize(new Dimension(70,20));
        chBiranjeBoje = new JColorChooser(Color.BLACK);

        //Predefinisana pravila za pojam
        tfIspisanTekst.setText("Pojam");
        tfDebljinaLinije.setText("1");

        btnIzaberi = new JButton("Izaberi");
        btnIzaberi.addActionListener(MainFrame.getInstance().getActionManager().getChooseAction());

        BoxLayout blVertikalni = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.getContentPane().setLayout(blVertikalni);

        JPanel panelZaBox = new JPanel();
        panelZaBox.add(lblDebljinaLinije);
        panelZaBox.add(tfDebljinaLinije);
        panelZaBox.setBorder(new EmptyBorder(30, 0, 0,0));
        JPanel panelZaBox2 = new JPanel();
        panelZaBox.add(lblIspisanTekst);
        panelZaBox.add(tfIspisanTekst);
        panelZaBox.setBorder(new EmptyBorder(30, 0, 0,0));

        JPanel panelZaDugme = new JPanel();
        panelZaDugme.add(btnIzaberi);
        panelZaDugme.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel panelZaBoju = new JPanel();
        panelZaDugme.add(chBiranjeBoje);
        panelZaDugme.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.add(panelZaBox);
        this.add(panelZaBox2);
        this.add(panelZaBoju);
        this.add(panelZaDugme);

    }

    public static ColorFrame getInstance(){
        if(instance == null){
            instance = new ColorFrame();
            instance.init();
        }
        return instance;
    }

}
