package raf.dsw.gerumap.gui.swing.error;

import raf.dsw.gerumap.core.ErrorLogger;
import raf.dsw.gerumap.gui.swing.messageGen.Message;

public class ConsoleLogger implements ErrorLogger {

    @Override
    public void log(Message message) {
        System.out.println(message.toString());
    }

    @Override
    public void update(Object notification) {
        this.log((Message) notification);
    }
}
