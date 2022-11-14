package raf.dsw.gerumap.core;

public interface IPublisher {
    void addSubscriber(ISubscriber sub);
    void removeSubscriber(ISubscriber sub);
    void notifySubscribers(Object notification);

    void notifyAuthorChanged(String newAuthor);
    void notifyProjectNameChanged(String newProjectName);

    void notifyMindMapCreated(String mindMapName);
    void notifyMindMapDeleted(String name);

    void notifyProjectOpened(Object project);

    void notifyMindMapNameChanged(String oldName, String newName);



}
