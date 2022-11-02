package raf.dsw.gerumap;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.core.MapRepository;
import raf.dsw.gerumap.gui.swing.SwingGui;
import raf.dsw.gerumap.mapRepository.MapRepositoryImpl;

public class AppCore extends ApplicationFramework{

    private static AppCore instance;

    private AppCore() {

    }

    public static void main(String[] args) {
        Gui gui = new SwingGui();
        MapRepository mapRepository = new MapRepositoryImpl();
        ApplicationFramework appCore = AppCore.getInstance();
        appCore.initialise(gui, mapRepository);
        appCore.run();
    }

    public void run() {
        this.gui.start();
    }

    public static AppCore getInstance() {
        if (instance == null) {
            instance = new AppCore();
        }

        return instance;
    }

    public static void setInstance(AppCore instance) {
        AppCore.instance = instance;
    }
}
