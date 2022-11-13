package raf.dsw.gerumap.gui.swing.messageGen;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;

@Getter
@Setter
public class Message {

    private String message;
    private ErrorType errorType;
    private ProblemType problemType;

    public Message(ErrorType errorType, ProblemType problemType) {
        this.errorType = errorType;
        this.problemType = problemType;
    }

    public Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
