package raf.dsw.gerumap;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.gui.swing.SwingGui;
import raf.dsw.gerumap.logger.ConsoleLogger;
import raf.dsw.gerumap.logger.FileLogger;
import raf.dsw.gerumap.logger.MessageGenerator;
import raf.dsw.gerumap.repository.MapRepository;
import raf.dsw.gerumap.serializer.GsonSerializer;


public class AppCore extends ApplicationFramework {

    FileLogger fileLogger = new FileLogger();
    ConsoleLogger consoleLogger = new ConsoleLogger();

    private static AppCore instance;
    private Gui gui;
    private MapRepository mapRepository;
    private MessageGenerator msgGenerator = new MessageGenerator();
    private GsonSerializer gsonSerializer = new GsonSerializer();

    private AppCore(){
    }

    @Override
    public void run() {
        gui = new SwingGui();
        mapRepository = new MapRepository();

        msgGenerator.addSubscriber(gui);
        msgGenerator.addSubscriber(fileLogger);
        msgGenerator.addSubscriber(consoleLogger);

        instance.initialise(gui, mapRepository);

        this.gui.start();
    }

    public static AppCore getInstance(){
        if(instance == null){
            instance = new AppCore();
        }
        return instance;
    }


    public static void main(String[] args) {
        ApplicationFramework appCore = AppCore.getInstance();
        appCore.run();
    }

    public MessageGenerator getMsgGenerator() {
        return msgGenerator;
    }

    public void setMsgGenerator(MessageGenerator msgGenerator) {
        this.msgGenerator = msgGenerator;
    }

    public GsonSerializer getGsonSerializer() {
        return gsonSerializer;
    }

    public void setGsonSerializer(GsonSerializer gsonSerializer) {
        this.gsonSerializer = gsonSerializer;
    }

    @Override
    public Gui getGui() {
        return gui;
    }

    @Override
    public void setGui(Gui gui) {
        this.gui = gui;
    }
}
