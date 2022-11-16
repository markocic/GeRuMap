package raf.dsw.gerumap.logger;

import raf.dsw.gerumap.gui.swing.observer.ISubscriber;
import raf.dsw.gerumap.repository.composite.MapNode;

import javax.swing.text.Utilities;
import java.util.ResourceBundle;

public class ConsoleLogger implements Logger {

    // genericno generisan no pun intended :)

    public ConsoleLogger() {

    }

    @Override
    public void update(Object notification) {
        // poziva log funkciju
        log(notification.toString());
    }

    @Override
    public void log(String tekst) {
        System.out.println(tekst);
    }


}
