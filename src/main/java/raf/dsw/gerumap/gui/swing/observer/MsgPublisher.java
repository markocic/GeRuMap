package raf.dsw.gerumap.gui.swing.observer;

public interface MsgPublisher {
    void addSubscriber(MsgSubscriber sub);
    void removeSubscriber(MsgSubscriber sub);
    void notifySubscribers();

}
