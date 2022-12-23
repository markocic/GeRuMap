package raf.dsw.gerumap.repository.command.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.repository.command.AbstractCommand;

import java.awt.*;
import java.util.ArrayList;

public class MoveCommand extends AbstractCommand {

    private int adjustedX;
    private int adjustedY;
    private ArrayList<ElementModel> selectedModels;

    public MoveCommand(int startX, int startY, int endX, int endY, ArrayList<ElementModel> selectedModels) {
        this.adjustedX = endX - startX;
        this.adjustedY = endY - startY;
        this.selectedModels = selectedModels;
    }

    @Override
    public void doCommand() {
        performMoveCommand(false);
    }

    @Override
    public void undoCommand() {
        performMoveCommand(true);

    }

    public void performMoveCommand(boolean reversed) {
        for (ElementModel model : selectedModels) {
            if (model instanceof VezaModel) continue;

            PojamModel pojamModel = (PojamModel) model;

            Point newPoint = null;
            if (reversed) newPoint = new Point((int) (pojamModel.getCoordinates().getX() - adjustedX), (int) (pojamModel.getCoordinates().getY() - adjustedY));
            else newPoint = new Point((int) (pojamModel.getCoordinates().getX() + adjustedX), (int) (pojamModel.getCoordinates().getY() + adjustedY));

            pojamModel.setCoordinates(newPoint);

            int pojamWidth = (int) pojamModel.getSize().getWidth();
            int pojamHeight = (int) pojamModel.getSize().getHeight();

            pojamModel.updateVeze(new Point(newPoint.x + pojamWidth / 2, newPoint.y + pojamHeight / 2));

        }
    }
}
