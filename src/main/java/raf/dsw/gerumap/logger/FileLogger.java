package raf.dsw.gerumap.logger;

import raf.dsw.gerumap.gui.swing.observer.ISubscriber;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

public class FileLogger implements Logger{

    // genericno generisan no pun intended :)
    File log = new File("log.txt");
    FileWriter fw;
    PrintWriter pw;

    public FileLogger() throws IOException {

    }


    public void log(String tekst) {
        // pise tekst u fajl
        // tekst je u formatu [TIP PORUKE] [TIME STAMP] tekst poruke
    }


    @Override
    public void update(Object notification) {
        // poziva log funkciju
        // error checkovi pre ovoga
        log(notification.toString());

    }
}
