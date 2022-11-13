package raf.dsw.gerumap.core;

public interface IPublisher {
    public void addSubscriber(ISubscriber sub);
    public void removeSubscriber(ISubscriber sub);
    public void notifySubscribers(Object notification);



}
