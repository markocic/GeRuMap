package raf.dsw.gerumap.logger;

import java.io.FileWriter;
import java.io.IOException;

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
