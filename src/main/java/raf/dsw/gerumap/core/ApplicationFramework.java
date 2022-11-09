package raf.dsw.gerumap.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationFramework {

    private static ApplicationFramework instance;
    protected Gui gui;
    protected MapRepository mapRepository;
    protected ErrorLogger errorLogger;
    protected MessageGenerator messageGenerator;

    private ApplicationFramework() {
    }

    public  void run(){
        this.gui.start();
    }

    public void initialise(Gui gui, MapRepository mapRepository, ErrorLogger errorLogger, MessageGenerator messageGenerator) {
        this.gui = gui;
        this.mapRepository = mapRepository;
        this.errorLogger = errorLogger;
        this.messageGenerator = messageGenerator;
    }

    public static ApplicationFramework getInstance(){
        if(instance == null){
            instance = new ApplicationFramework();
        }
        return instance;
    }


}
