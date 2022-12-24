package raf.dsw.gerumap.core;

import raf.dsw.gerumap.logger.Logger;
import raf.dsw.gerumap.repository.MapRepository;

public abstract class ApplicationFramework {
    protected Gui gui;
    protected Logger logger;
    protected MapRepository mapRepository;


    public ApplicationFramework() {
    }

    public abstract void run();
    public void initialise(Gui gui, MapRepository mapRepository){
        this.gui = gui;
        this.mapRepository = mapRepository;
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public Gui getGui() {
        return gui;
    }

    public MapRepository getMapRepository() {
        return mapRepository;
    }

    public void setMapRepository(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
