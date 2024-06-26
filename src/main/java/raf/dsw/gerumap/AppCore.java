package raf.dsw.gerumap;

import raf.dsw.gerumap.core.*;
import raf.dsw.gerumap.gui.swing.SwingGui;
import raf.dsw.gerumap.gui.swing.error.LoggerType;
import raf.dsw.gerumap.gui.swing.error.LoggerFactory;
import raf.dsw.gerumap.mapRepository.MapRepositoryImpl;
import raf.dsw.gerumap.gui.swing.messageGen.MessageGenImpl;
import raf.dsw.gerumap.serializer.GsonSerializer;

public class AppCore {

    public static void main(String[] args) {

        ApplicationFramework applicationFramework = ApplicationFramework.getInstance();
        Gui gui = new SwingGui();
        MapRepository mapRepository = new MapRepositoryImpl();
        ErrorLogger errorLogger = LoggerFactory.createLogger(LoggerType.CONSOLE_LOGGER);
        MessageGenerator messageGenerator = new MessageGenImpl();
        messageGenerator.addSubs(errorLogger);
        messageGenerator.addSubs(gui);
        Serializer serializer = new GsonSerializer();
        applicationFramework.initialise(gui,mapRepository, errorLogger, messageGenerator, serializer);
        applicationFramework.run();
    }



}
