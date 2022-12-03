package raf.dsw.gerumap.gui.swing.observer;

import raf.dsw.gerumap.repository.implementation.MindMap;

public interface ISubscriber {
    void update(Object notification);
    void updateAuthorName(String newAuthor);
    void updateProjectNameChanged(String newProjectName);
    void updateMindMapCreated(MindMap mindMap);
    void updateMindMapDeleted(String name);
    void updateProjectOpened(Object project);
    void updateMindMapNameChanged(String oldName, String newName);
    void updateOpenedProjectDeleted();
}
