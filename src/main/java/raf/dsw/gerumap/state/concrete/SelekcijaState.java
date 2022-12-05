package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.state.State;

import java.awt.*;

public class SelekcijaState  extends State {
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        map.deselectAll();
        ElementPainter clicked = getPainterAtClickedLocation(new Point(x, y), map);
        if (!(clicked instanceof PojamPainter)) return;

        map.addSelectedPainter(clicked);
    }

    public ElementPainter getPainterAtClickedLocation(Point point, MapView map) {
        for (ElementPainter painter : map.getPainters()) {
            if (painter.elementAt(point)) return painter;
        }

        return null;
    }
}
