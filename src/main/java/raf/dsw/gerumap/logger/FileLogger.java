package raf.dsw.gerumap.logger;

import raf.dsw.gerumap.gui.swing.observer.ISubscriber;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

public class FileLogger extends Logger{

    // genericno generisan no pun intended :)
    File log = new File("/logger");
    FileWriter fw = new FileWriter(log);
    PrintWriter pw = new PrintWriter(fw);

    public FileLogger() throws IOException {

    }



}
