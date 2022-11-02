package raf.dsw.gerumap.core;

public abstract class ApplicationFramework {

    protected Gui gui;
    protected MapRepository mapRepository;

    public ApplicationFramework() {
    }

    public abstract void run();

    public void initialise(Gui gui) {
        this.gui = gui;
    }

    public void setMapRepository(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }
}
