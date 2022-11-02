package raf.dsw.gerumap.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ApplicationFramework {

    protected Gui gui;
    protected MapRepository mapRepository;

    public ApplicationFramework() {
    }

    public abstract void run();

    public void initialise(Gui gui, MapRepository mapRepository) {
        this.gui = gui;
        this.mapRepository = mapRepository;
    }

    public void setMapRepository(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }
}
