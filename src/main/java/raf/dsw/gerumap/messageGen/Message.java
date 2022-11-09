package raf.dsw.gerumap.messageGen;

import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;

public class Message {

    private ErrorType errorType;
    private ProblemType problemType;

    public Message(ErrorType errorType, ProblemType problemType) {
        this.errorType = errorType;
        this.problemType = problemType;
    }
}
