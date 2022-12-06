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

    public ArrayList<ElementPainter> getVezePojma(ElementPainter pojam, MapView map) {
        ArrayList<ElementPainter> vezaPainterList = new ArrayList<>();

        for (ElementPainter painter : map.getPainters()) {
            if (painter instanceof VezaPainter) {
                VezaModel vezaModel = (VezaModel) painter.getElement();
                if (vezaModel.getOdPojma().equals(pojam.getElement()) || vezaModel.getDoPojma().equals(pojam.getElement())) {
                    vezaPainterList.add(painter);
                }
            }
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
