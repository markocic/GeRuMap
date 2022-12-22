package raf.dsw.gerumap.repository.command.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.implementation.MindMap;

public class PojamCommand extends AbstractCommand {

    private MindMap mindMap;
    private PojamModel pojamModel;

    public PojamCommand(MindMap mindMap, PojamModel pojamModel) {
        this.mindMap = mindMap;
        this.pojamModel = pojamModel;
    }

    @Override
    public void doCommand() {
        mindMap.addModel(pojamModel);
    }

    @Override
    public void undoCommand() {
        mindMap.removeModel(pojamModel);
    }
}
