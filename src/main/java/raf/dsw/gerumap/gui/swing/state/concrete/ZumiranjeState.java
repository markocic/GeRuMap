package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class ZumiranjeState  extends State{

    private int startX;
    private int startY;

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        MapView map = (MapView) e.getSource();
        double zoom = map.getZoom();
        if (e.getPreciseWheelRotation() < 0) zoom = zoom + 0.01;
        else zoom -= 0.01;

        if (zoom < 0.01) zoom = 0.01;

        map.setZoom(zoom);

        double width = map.getWidth();
        double height = map.getHeight();

        double zoomWidth = 800 * zoom;
        double zoomHeight = 400 * zoom;

        map.setTransform(new AffineTransform());
        map.getTransform().translate(width / 2, height / 2);
        map.getTransform().scale(zoom, zoom);
        map.getTransform().translate(-width / 2, -height / 2);

        map.setPreferredSize(new Dimension((int) zoomWidth, (int) zoomHeight));
        map.getjScrollPane().setPreferredSize(new Dimension(826, 422));

        map.getjScrollPane().getViewport().revalidate();
        map.getjScrollPane().getViewport().repaint();

    }

    @Override
    public void mousePressedState(int x, int y, MapView map) {
        startX = x;
        startY = y;
    }

    @Override
    public void mouseReleasedState(int x, int y, MapView map) {
        updateSelectedPainters((ArrayList<ElementPainter>) map.getPainters(), x - startX, y - startY);
    }

    @Override
    public void mouseDraggedState(int x, int y, MapView map) {
        updateSelectedPainters((ArrayList<ElementPainter>) map.getPainters(), x - startX, y - startY);

        startX = x;
        startY = y;
    }
}
