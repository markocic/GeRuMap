package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class PomeranjeState  extends State {

    private int startX;
    private int startY;
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        startX = x;
        startY = y;
    }

    @Override
    public void mouseReleasedState(int x, int y, MapView map) {
        updateSelectedPainters(map.getSelectedPainters(), x - startX, y - startY);

    }

    @Override
    public void mouseDraggedState(int x, int y, MapView map) {
        updateSelectedPainters(map.getSelectedPainters(), x - startX, y - startY);

        startX = x;
        startY = y;
    }

    public void updateSelectedPainters(ArrayList<ElementPainter> painters, int adjustedX, int adjustedY) {
        for (ElementPainter painter : painters) {

            PojamModel pojamModel = (PojamModel) painter.getElement();
            Point newPoint = new Point((int) (pojamModel.getCoordinates().getX() + adjustedX), (int) (pojamModel.getCoordinates().getY() + adjustedY));

            pojamModel.setCoordinates(newPoint);

            Ellipse2D elipsa = (Ellipse2D) painter.getShape();
            elipsa.setFrame(newPoint, pojamModel.getSize());

            pojamModel.updateVeze(new Point((int) elipsa.getCenterX(), (int) elipsa.getCenterY()));
        }

    }
}
