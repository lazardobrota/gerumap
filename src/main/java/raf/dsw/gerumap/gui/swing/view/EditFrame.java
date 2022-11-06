package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;


@Getter
@Setter
public class EditFrame extends JDialog {

    private static EditFrame instance = null;
    private JLabel lblNazivAutora;
    private JTextField tfNazivAutora;
    private JButton btnSave;

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
    }


    public EditFrame getInstance(){
        if(instance == null){
            instance = new EditFrame();
            instance.init();
        }
        return instance;
    }

}
