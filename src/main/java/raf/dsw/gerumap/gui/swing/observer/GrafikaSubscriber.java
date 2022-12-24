package raf.dsw.gerumap.gui.swing.observer;

import raf.dsw.gerumap.repository.command.CommandType;

public interface GrafikaSubscriber {
    void update(CommandType commandType, Object obj);
    void updateShape(Object obj1, Object obj2);
}
