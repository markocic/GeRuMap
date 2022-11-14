package raf.dsw.gerumap.core;

public interface ISubscriber {
    void update(Object notification);
    void updateAuthorName(String newAuthor);
    void updateMindMapDeleted(String name);
    void updateProjectNameChanged(String newProjectName);
}
