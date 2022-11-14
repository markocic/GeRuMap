package raf.dsw.gerumap.logger;

import raf.dsw.gerumap.gui.swing.observer.ISubscriber;

import java.util.ResourceBundle;

public class FileLogger implements Logger, ISubscriber {

    // genericno generisan no pun intended :)

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isLoggable(Level level) {
        return false;
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {

    }

    @Override
    public void log(Level level, ResourceBundle bundle, String format, Object... params) {

    }

    @Override
    public void update(Object notification) {

    }

    @Override
    public void updateAuthorName(String newAuthor) {

    }

    @Override
    public void updateProjectNameChanged(String newProjectName) {

    }

    @Override
    public void updateMindMapCreated(String mindMapName) {

    }

    @Override
    public void updateMindMapDeleted(String name) {

    }

    @Override
    public void updateProjectOpened(Object project) {

    }

    @Override
    public void updateMindMapNameChanged(String oldName, String newName) {

    }

    @Override
    public void updateOpenedProjectDeleted() {

    }
}
