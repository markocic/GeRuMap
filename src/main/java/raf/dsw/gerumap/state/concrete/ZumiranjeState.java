package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;

public class ZumiranjeState  extends State{

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        MapView map = (MapView) e.getSource();
        double zoom = map.getZoom();
        if (e.getPreciseWheelRotation() > 0) zoom = zoom + 0.01;
        else zoom -= 0.01;

        if (zoom < 0.01) zoom = 0.01;

        map.setZoom(zoom);

        double width = map.getWidth();
        double height = map.getHeight();

        double zoomWidth = width * zoom;
        double zoomHeight = height * zoom;

        map.setTransform(new AffineTransform());
        map.getTransform().translate(width / 2, height / 2);
        map.getTransform().scale(zoom, zoom);
        map.getTransform().translate(-width / 2, -height / 2);

        map.setPreferredSize(new Dimension((int) zoomWidth, (int) zoomHeight));

        System.out.println("JScroll: " + map.getjScrollPane().getPreferredSize().toString());
        System.out.println("Map: " + map.getPreferredSize().toString());
        map.getjScrollPane().updateUI();
        map.repaint();
    }
}
