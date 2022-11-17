package raf.dsw.gerumap.gui.swing.messageGen;

import raf.dsw.gerumap.core.MessageGenerator;
import raf.dsw.gerumap.gui.swing.error.ErrorType;
import raf.dsw.gerumap.gui.swing.error.ProblemType;
import raf.dsw.gerumap.gui.swing.observer.Subscriber;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageGenImpl implements MessageGenerator {

    List<Subscriber> subscribers = new ArrayList<>();
    String time = new SimpleDateFormat("dd.M.yy. hh:mm").format(new Date());

    @Override
    public void generateMessage(ErrorType errorType, ProblemType problemType) {
        this.notifySubs(new Message("[" + errorType + "] [" + time + "] [" + problemType.toString().replaceAll("_", " ") + "]"));
    }

    @Override
    public void notifySubs(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;


        for(Subscriber listener : subscribers){
            listener.update(notification);
        }
    }

    @Override
    public void addSubs(Subscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubs(Subscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }
}
