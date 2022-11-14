package raf.dsw.gerumap.core;

public interface IPublisher {
    void addSubscriber(ISubscriber sub);
    void removeSubscriber(ISubscriber sub);
    void notifySubscribers(Object notification);

    void notifyAuthorChanged(String newAuthor);
    void notifyProjectNameChanged(String newProjectName);

    void notifyMindMapDeleted(String name);



}
