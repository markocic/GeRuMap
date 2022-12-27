package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class SelekcijaState  extends State {

    private Rectangle2D selekcijaShape;
    private int startX;
    private int startY;
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        selekcijaShape = new Rectangle2D.Double(x, y, 1 ,1);
        map.setSelekcijaRect(selekcijaShape);
        startX = x;
        startY = y;
        checkSelection(map);
    }

    @Override
    public void mouseReleasedState(int x, int y, MapView map) {
        map.setSelekcijaRect(new Rectangle2D.Double());

    }

    @Override
    public void mouseDraggedState(int x, int y, MapView map) {
        updateSelectionRect(map, x, y);

        checkSelection(map);

    }

    public void checkSelection(MapView map) {
        map.deselectAll();
        ArrayList<ElementPainter> results = new ArrayList<>();
        for (ElementPainter painter : map.getPainters()) {
            if (map.getSelekcijaRect().intersects(painter.getShape().getBounds())) {
                results.add(painter);
            }
        }

        if (results.isEmpty()) return;

        for (ElementPainter selected : results) {
            map.addSelectedPainter(selected);
        }
    }

    public void updateSelectionRect(MapView map, int x, int y) {
        selekcijaShape.setFrameFromDiagonal(new Point(startX, startY), new Point(x, y));
        map.setSelekcijaRect(selekcijaShape);
    }

}
