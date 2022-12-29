package raf.dsw.gerumap.gui.swing.observer;

public interface Publisher {
    void notifySubs(Object notification);
    void addSubs(Subscriber sub);
    void removeSubs(Subscriber sub);
}
