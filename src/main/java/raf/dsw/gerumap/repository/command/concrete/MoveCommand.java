package raf.dsw.gerumap.repository.command.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.repository.command.AbstractCommand;

import java.awt.*;
import java.util.ArrayList;

public class MoveCommand extends AbstractCommand {

    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private int adjustedX;
    private int adjustedY;
    private ArrayList<ElementModel> selectedModels;

    public MoveCommand(int startX, int startY, int endX, int endY, ArrayList<ElementModel> selectedModels) {
        this.startX = startX;
        this.startY = startY;
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

        }
    }

    public void updateMove(int adjustedX, int adjustedY) {
        this.adjustedX = adjustedX;
        this.adjustedY = adjustedY;

        performMoveCommand(false);
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
        this.adjustedX = endX - startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
        this.adjustedY = endY - startY;
    }
}
