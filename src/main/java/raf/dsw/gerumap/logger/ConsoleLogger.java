package raf.dsw.gerumap.logger;

import raf.dsw.gerumap.gui.swing.observer.ISubscriber;
import raf.dsw.gerumap.repository.composite.MapNode;

import javax.swing.text.Utilities;
import java.util.ResourceBundle;

public class ConsoleLogger implements Logger,ISubscriber {


    // genericno generisan no pun intended :)


    public ConsoleLogger() {

    }

    @Override
    public void update(Object notification) {
        System.out.println(" " +  java.time.LocalTime.now() + "NOTIFICATION:" + notification );
    }

    @Override
    public void updateAuthorName(String newAuthor) {
        System.out.println(" " +  java.time.LocalTime.now() + "New author : " + newAuthor);
    }

    @Override
    public void updateProjectNameChanged(String newProjectName) {
        System.out.println(" " +  java.time.LocalTime.now() + "PROJECT NAME CHANGE: " + newProjectName);
    }

    @Override
    public void updateMindMapCreated(String mindMapName) {
        System.out.println(" " +  java.time.LocalTime.now() + "MINDMAP NAME CHANGE: " + mindMapName);
    }

    @Override
    public void updateMindMapDeleted(String name) {
        System.out.println(" " +  java.time.LocalTime.now() + "DELETED MINDMAP: " + name);
    }

    @Override
    public void updateProjectOpened(Object project) {
        System.out.println(" " +  java.time.LocalTime.now() + "OPENED PROJECT: " + project);
    }

    @Override
    public void updateMindMapNameChanged(String oldName, String newName) {
        System.out.println(" " +  java.time.LocalTime.now() + "MINDMAP " + oldName + "NEW NAME : " + newName);
    }

    @Override
    public void updateOpenedProjectDeleted() {
        System.out.println(" " +  java.time.LocalTime.now() + "OPENED PROJECT HAS BEEN DELETED");
    }
}
