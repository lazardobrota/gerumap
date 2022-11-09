package raf.dsw.gerumap.core;

import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
import raf.dsw.gerumap.messageGen.Message;

public interface MessageGenerator {

    Message generateMessage(ErrorType errorType, ProblemType problemType);
}
