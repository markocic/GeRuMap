package raf.dsw.gerumap;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.gui.swing.SwingGui;
import raf.dsw.gerumap.logger.MessageGenerator;
import raf.dsw.gerumap.repository.MapRepository;


public class AppCore extends ApplicationFramework {

    private static AppCore instance;
    private MessageGenerator msgGenerator = new MessageGenerator();

    private AppCore() {
    }

    @Override
    public void run() {
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
