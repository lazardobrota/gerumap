package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


@Getter
@Setter
public class EditFrame extends JDialog {

    private static EditFrame instance = null;
    private JLabel lblNazivAutora;
    private JTextField tfNazivAutora;
    private JButton btnSacuvaj;

    private EditFrame(){}

    private void init(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = (int) screenSize.getHeight();
        int screenWidth = (int) screenSize.getWidth();
        this.setSize(screenWidth / 5 + 20, screenHeight / 2 - 50);
        this.setLocationRelativeTo(MainFrame.getInstance());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("Izaberite ime autora");

        lblNazivAutora = new JLabel("Unesite naziv autora: ");
        tfNazivAutora = new JTextField("");
        tfNazivAutora.setPreferredSize(new Dimension(70,20));
        btnSacuvaj = new JButton("Sacuvaj");


        BoxLayout blVertikalni = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.getContentPane().setLayout(blVertikalni);

        JPanel panelZaBox = new JPanel();
        panelZaBox.add(lblNazivAutora);
        panelZaBox.add(tfNazivAutora);
        panelZaBox.setBorder(new EmptyBorder(30, 0, 0,0));

        JPanel panelZaDugme = new JPanel();
        panelZaDugme.add(btnSacuvaj);
        panelZaDugme.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.add(panelZaBox);
        this.add(panelZaDugme);

        btnSacuvaj.addActionListener(MainFrame.getInstance().getActionManager().getAutorAction());

    }


    public static EditFrame getInstance(){
        if(instance == null){
            instance = new EditFrame();
            instance.init();
        }
        return instance;
    }

}
