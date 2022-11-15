package raf.dsw.gerumap.logger;

import raf.dsw.gerumap.gui.swing.observer.ISubscriber;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

public class FileLogger implements Logger, ISubscriber {

    // genericno generisan no pun intended :)
    File log = new File("/logger");
    FileWriter fw = new FileWriter(log);
    PrintWriter pw = new PrintWriter(fw);

    public FileLogger() throws IOException {

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
