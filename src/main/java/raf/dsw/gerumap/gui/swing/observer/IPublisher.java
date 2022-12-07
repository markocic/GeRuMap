package raf.dsw.gerumap.gui.swing.observer;

import raf.dsw.gerumap.repository.implementation.MindMap;

public interface IPublisher {
    void addSubscriber(ISubscriber sub);
    void removeSubscriber(ISubscriber sub);
    void notifySubscribers(Object notification);

    void notifyAuthorChanged(String newAuthor);
    void notifyProjectNameChanged(String newProjectName);

    void notifyMindMapCreated(MindMap mindMap);
    void notifyMindMapDeleted(String name);

    void notifyProjectOpened(Object project);
    void notifyOpenedProjectDeleted();
    void notifyMindMapNameChanged(String oldName, String newName);


}
