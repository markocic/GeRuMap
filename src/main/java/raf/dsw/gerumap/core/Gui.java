package raf.dsw.gerumap.core;

import raf.dsw.gerumap.gui.swing.command.CommandManager;
import raf.dsw.gerumap.gui.swing.observer.MsgSubscriber;

public interface Gui extends MsgSubscriber {
    void start();
    void disabelUndoAction();
    void disableRedoAction();
    void enableUndoAction();
    void enableRedoAction();

    CommandManager getCommandManager();

}
