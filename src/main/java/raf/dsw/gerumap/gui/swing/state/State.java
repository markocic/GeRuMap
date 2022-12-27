package raf.dsw.gerumap.gui.swing.state;

import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.VezaPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public abstract class State {
    public void mousePressedState(int x, int y, MapView map) {}

    public void mouseReleasedState(int x, int y, MapView map) {}

    public void mouseDraggedState(int x, int y, MapView map) {}

    public void mouseWheelMoved(MouseWheelEvent e) {}

    public ElementPainter getPainterAtClickedLocation(Point point, MapView map) {
        for (ElementPainter painter : map.getPainters()) {
            if (painter.elementAt(point)) return painter;
        }

        return null;
    }

    public PojamPainter getPojamPainterAtClickedLocation(Point point, MapView map) {
        for (ElementPainter painter : map.getPainters()) {
            if (painter instanceof PojamPainter && painter.elementAt(point)) return (PojamPainter) painter;
        }

        return null;
    }

    public ArrayList<ElementModel> getVezePojma(ElementPainter pojam, MapView map) {
        ArrayList<ElementModel> vezaModelList = new ArrayList<>();

        PojamModel pojamModel = (PojamModel) pojam.getElement();
        vezaModelList.addAll(pojamModel.getDolazeceVeze());

        vezaModelList.addAll(pojamModel.getOdlazeceVeze());

        return vezaModelList;
    }


    public boolean pojamNameExists(String name, MapView map) {

        for (ElementPainter painter : map.getPainters()) {
            if (painter instanceof PojamPainter && name.equals(((PojamModel) painter.getElement()).getName())) {
                return true;
            }
        }

        return false;
    }

    public void updateSelectedPainters(ArrayList<ElementPainter> painters, int adjustedX, int adjustedY) {
        for (ElementPainter painter : painters) {
            if (painter instanceof VezaPainter) {
                continue;
            }
            PojamModel pojamModel = (PojamModel) painter.getElement();
            Point newPoint = new Point((int) (pojamModel.getCoordinates().getX() + adjustedX), (int) (pojamModel.getCoordinates().getY() + adjustedY));

            pojamModel.setCoordinates(newPoint);

            Ellipse2D elipsa = (Ellipse2D) painter.getShape();
            elipsa.setFrame(newPoint, pojamModel.getSize());


            pojamModel.updateVeze(new Point((int) elipsa.getCenterX(), (int) elipsa.getCenterY()));
        }

    }


    public ArrayList<ElementModel> getSelectedModels(ArrayList<ElementPainter> selectedPainters) {

        ArrayList<ElementModel> models = new ArrayList<>();

        for (ElementPainter painter : selectedPainters) {
            models.add(painter.getElement());
        }

        return models;
    }
}
