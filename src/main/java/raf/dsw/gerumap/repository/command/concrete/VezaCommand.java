package raf.dsw.gerumap.repository.command.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.implementation.MindMap;

public class VezaCommand extends AbstractCommand {

    private MindMap mindMap;
    private VezaModel vezaModel;

    public VezaCommand(MindMap mindMap, VezaModel vezaModel) {
        this.mindMap = mindMap;
        this.vezaModel = vezaModel;
    }

    @Override
    public void doCommand() {
        mindMap.addModelAtIndex(vezaModel, 0);
    }

    @Override
    public void undoCommand() {
        mindMap.removeModel(vezaModel);
    }
}
