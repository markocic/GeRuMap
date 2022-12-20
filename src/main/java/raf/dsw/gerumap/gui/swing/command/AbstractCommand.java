package raf.dsw.gerumap.gui.swing.command;

public abstract class AbstractCommand {
    public abstract void doCommand();
    //ove metode sada moramo da ubacimo unutar ovih postojecih da bi se omogucio undo i redo
    public abstract void undoCommand();
}
