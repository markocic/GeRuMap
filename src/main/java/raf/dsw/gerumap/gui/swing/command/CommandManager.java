package raf.dsw.gerumap.gui.swing.command;

import javax.swing.*;
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

    }

    public void undoCommand(){


    }


}
