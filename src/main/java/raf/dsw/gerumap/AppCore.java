package raf.dsw.gerumap;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.gui.swing.SwingGui;
import raf.dsw.gerumap.logger.ConsoleLogger;
import raf.dsw.gerumap.logger.FileLogger;
import raf.dsw.gerumap.logger.MessageGenerator;
import raf.dsw.gerumap.repository.MapRepository;

import java.io.IOException;


public class AppCore extends ApplicationFramework {

    FileLogger fileLogger = new FileLogger();
    ConsoleLogger consoleLogger = new ConsoleLogger();

    private static AppCore instance;
    private MessageGenerator msgGenerator = new MessageGenerator();

    private AppCore(){
    }

    @Override
    public void run() {
        msgGenerator.addSubscriber(gui);
        msgGenerator.addSubscriber(fileLogger);
        msgGenerator.addSubscriber(consoleLogger);
        this.gui.start();
    }

    public static AppCore getInstance(){
        if(instance == null){
            instance = new AppCore();
        }
        return instance;
    }


    public static void main(String[] args) {
        Gui gui = new SwingGui();
        MapRepository mapRepository = new MapRepository();
        ApplicationFramework appCore = AppCore.getInstance();
        appCore.initialise(gui, mapRepository);
        appCore.run();

    }

    public MessageGenerator getMsgGenerator() {
        return msgGenerator;
    }

    public void setMsgGenerator(MessageGenerator msgGenerator) {
        this.msgGenerator = msgGenerator;
    }
}
