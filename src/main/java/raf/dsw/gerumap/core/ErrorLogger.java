package raf.dsw.gerumap.core;

import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.messageGen.Message;
import raf.dsw.gerumap.gui.swing.observer.Subscriber;

public interface ErrorLogger extends Subscriber {

    void log(Message message);
}
