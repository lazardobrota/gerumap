package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.controller.ActionManager;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MainFrame extends JFrame {

    private static MainFrame instance;//pravimo jednu instancu glavnog prozora??
    private ActionManager actionManager;//imamo sve moguce akcije za dugmice na jednom mestu
    private JMenuBar menu;
    private JToolBar toolBar;

    private MainFrame() {
    }

    private void initialise() {
        actionManager = new ActionManager();
        initGui();
    }

    private void initGui() {
        //Omogucava kreiranje GUI komponente iz paketa na bilo kojoj platformi(Windows, IOS, Linux, ...)
        Toolkit kit = Toolkit.getDefaultToolkit();
        //Dobijamo dimenzije racunara za visinu i sirinu
        Dimension screenSize = kit.getScreenSize();
        //Na osnovu dimenzija znamo dimenzije bilo kog kompjutera i uvek mozemo na isto mesto da im postavimo aplikaciju
        //bez obzira na rezoluciju
        int screenHeight = (int) screenSize.getHeight();
        int screenWidth = (int) screenSize.getWidth();
        this.setSize(screenWidth / 2, screenHeight / 2);
        this.setLocationRelativeTo(null);//postavlja na sredini ekrana aplikaciju
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close operacija(onaj x desno gore) zatvara aplikaciju skroz
        this.setTitle("GeRuMap");


        menu = new MyMenuBar();
        this.setJMenuBar(menu);

        toolBar = new Toolbar();
        this.add(toolBar, BorderLayout.NORTH);

        JPanel panel = new JPanel();

        JScrollPane scroll = new JScrollPane();
        scroll.setMinimumSize(new Dimension(200, 150));

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, panel); // ono sto deli project explorer i radnu tablu
        this.getContentPane().add(split, BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }

        return instance;
    }

}
