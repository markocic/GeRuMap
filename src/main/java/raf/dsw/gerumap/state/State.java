package raf.dsw.gerumap.state;

import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.implementation.MindMap;

import java.awt.*;

public abstract class State {
    public void mousePressedState(int x, int y, MapView map) {
//        System.out.println("placeholder mouse pressed, need to be overridden");
    }

    public void mouseReleasedState(int x, int y, MapView map) {
//        System.out.println("placeholder mouse released, need to be overridden");
    }

    public void mouseDraggedState(int x, int y, MapView map) {
//        System.out.println("placeholder mouse dragged, need to be overridden");
    }

    public ElementPainter getPainterAtClickedLocation(Point point, MapView map) {
        for (ElementPainter painter : map.getPainters()) {
            if (painter.elementAt(point)) return painter;
        }

        return null;
    }
}
