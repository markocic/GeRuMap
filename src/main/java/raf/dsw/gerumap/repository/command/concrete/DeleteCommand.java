package raf.dsw.gerumap.repository.command.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.implementation.MindMap;

import java.util.ArrayList;

public class DeleteCommand extends AbstractCommand {

    private MindMap mindMap;
    private ArrayList<ElementModel> models;

    public DeleteCommand(MindMap mindMap, ArrayList<ElementModel> models) {
        this.mindMap = mindMap;
        this.models = models;
    }

    @Override
    public void doCommand() {
        mindMap.removeModels(models);

    }

    @Override
    public void undoCommand() {
        for (ElementModel model : models) {
            if (model instanceof PojamModel) mindMap.addModel(model);
            else if (model instanceof VezaModel) mindMap.addModelAtIndex(model, 0);
        }
    }
}
