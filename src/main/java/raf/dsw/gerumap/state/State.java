package raf.dsw.gerumap.state;

import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.VezaPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.implementation.MindMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public abstract class State {
    public void mousePressedState(int x, int y, MapView map) {}

    public void mouseReleasedState(int x, int y, MapView map) {}

    public void mouseDraggedState(int x, int y, MapView map) {}

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

    public ArrayList<ElementPainter> getVezePojma(ElementPainter pojam, MapView map) {
        ArrayList<ElementPainter> vezaPainterList = new ArrayList<>();

        PojamModel pojamModel = (PojamModel) pojam.getElement();
        for (VezaModel veza : pojamModel.getDolazeceVeze()) {
            vezaPainterList.add(new VezaPainter(veza));
        }

        for (VezaModel veza : pojamModel.getOdlazeceVeze()) {
            vezaPainterList.add(new VezaPainter(veza));
        }

        return vezaPainterList;
    }


    public boolean pojamNameExists(String name, MapView map) {

        for (ElementPainter painter : map.getPainters()) {
            if (painter instanceof PojamPainter && name.equals(((PojamModel) painter.getElement()).getName())) {
                return true;
            }
        }

        return false;
    }
}
