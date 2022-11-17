package raf.dsw.gerumap.gui.swing.messageGen;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class Message {

    private String message;
    private ErrorType errorType;
    private ProblemType problemType;
    String time = new SimpleDateFormat("dd.M.yy. hh:mm").format(new Date());

    public Message(ErrorType errorType, ProblemType problemType) {
        this.errorType = errorType;
        this.problemType = problemType;
        this.message = "[" + errorType + "] [" + time + "] [" + problemType.toString().replaceAll("_", " ") + "]";
    }

    @Override
    public String toString() {
        return message;
    }
}
