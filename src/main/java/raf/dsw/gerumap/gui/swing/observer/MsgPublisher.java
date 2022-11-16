package raf.dsw.gerumap.gui.swing.observer;

public interface MsgPublisher {
    void addSubscriber(ISubscriber sub);
    void removeSubscriber(ISubscriber sub);
    void notifySubscribers(Object notification);

}
