package raf.dsw.gerumap.logger;

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
