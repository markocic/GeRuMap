package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.state.State;

import java.awt.*;

public class BrisanjeState extends State {
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        ElementPainter selected = getPainterAtClickedLocation(new Point(x, y), map);
        if (!(selected instanceof PojamPainter)) return;
        if (map.getSelectedPainters().contains(selected)) map.deleteSelectedPainters();
    }
}
