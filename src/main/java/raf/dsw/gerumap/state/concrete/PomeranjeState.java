package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.state.State;

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


}
