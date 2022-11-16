package raf.dsw.gerumap.logger;

import raf.dsw.gerumap.gui.swing.observer.ISubscriber;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

public class FileLogger implements Logger{

    // genericno generisan no pun intended :)

    public FileLogger(){
    }

    public void log(String tekst) {
        // pise tekst u fajl
        // tekst je u formatu [TIP PORUKE] [TIME STAMP] tekst poruke
        FileWriter fw;
        try {
            fw = new FileWriter("log.txt",true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fw.write(tekst);
            fw.write("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public void update(Object notification) {
        // poziva log funkciju
        // error checkovi pre ovoga
        log(notification.toString());

    }
}
