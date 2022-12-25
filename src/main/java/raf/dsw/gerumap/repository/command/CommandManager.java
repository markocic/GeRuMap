package raf.dsw.gerumap.repository.command;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.SwingGui;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private List<AbstractCommand> komande = new ArrayList<>();
    private int currentCommand = 0;


    public void addCommand(AbstractCommand command){
        while(currentCommand < komande.size()){
            komande.remove(currentCommand);
        }
        komande.add(command);
        doCommand();
    }

    public void doCommand(){
        if(currentCommand < komande.size()) komande.get(currentCommand++).doCommand();

        ((SwingGui) AppCore.getInstance().getGui()).refreshUndoRedoButtons();
    }

    public void undoCommand(){
        if(currentCommand > 0) komande.get(--currentCommand).undoCommand();

        ((SwingGui) AppCore.getInstance().getGui()).refreshUndoRedoButtons();
    }

    public List<AbstractCommand> getKomande() {
        return komande;
    }

    public void setKomande(List<AbstractCommand> komande) {
        this.komande = komande;
    }

    public int getCurrentCommand() {
        return currentCommand;
    }

    public void setCurrentCommand(int currentCommand) {
        this.currentCommand = currentCommand;
    }
}
