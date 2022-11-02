package raf.dsw.gerumap.core;

import raf.dsw.gerumap.repository.MapRepository;

public abstract class ApplicationFramework {
    protected Gui gui;
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
}
