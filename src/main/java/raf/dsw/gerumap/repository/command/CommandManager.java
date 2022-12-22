package raf.dsw.gerumap.repository.command;

import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private List<AbstractCommand> komande = new ArrayList<>();
    //nas stack ili lancana lista ako ce se znati
    private int currentCommand = 0;
    //nas index koji koristimo radi iteriranja ako sam dobro shvatio


    public void addCommand(AbstractCommand command){
        while(currentCommand < komande.size()){
            komande.remove(currentCommand);
        }
        komande.add(command);
        doCommand();
    }

    public void doCommand(){
        if(currentCommand < komande.size()){
            komande.get(currentCommand++).doCommand();
            //unutar ovoga se pozvia ono sto se tacno trazi da se desi
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
        }else if(currentCommand == komande.size()){
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
        }
    }

    public void undoCommand(){
        if(currentCommand > 0){
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
            komande.get(--currentCommand).undoCommand();
        }else if(currentCommand == komande.size()){
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
        }
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
