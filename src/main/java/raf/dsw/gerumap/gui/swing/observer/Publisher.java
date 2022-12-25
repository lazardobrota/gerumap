package raf.dsw.gerumap.gui.swing.observer;

public interface Publisher {//todo ANA hoce da bude abstract
    void notifySubs(Object notification);
    void addSubs(Subscriber sub);
    void removeSubs(Subscriber sub);
}
