package raf.dsw.gerumap.gui.swing.observer;

public interface Subscriber {
    void update(Object notification);
    void projectRename(Object notification);
}
