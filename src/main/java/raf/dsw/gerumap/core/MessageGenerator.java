package raf.dsw.gerumap.core;

import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
import raf.dsw.gerumap.gui.swing.observer.Publisher;

public interface MessageGenerator extends Publisher {

    void generateMessage(ErrorType errorType, ProblemType problemType);
}
