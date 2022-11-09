package raf.dsw.gerumap.messageGen;

import raf.dsw.gerumap.core.MessageGenerator;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;

public class MessageGenImpl implements MessageGenerator {

    @Override
    public Message generateMessage(ErrorType errorType, ProblemType problemType) {
        return new Message(errorType, problemType);
    }
}
