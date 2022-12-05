package raf.dsw.gerumap.state;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.implementation.MindMap;

public abstract class State {
    public void mousePressedState(int x, int y, MapView map) {
        System.out.println("placeholder mouse pressed, need to be overridden");
    }

    public void mouseReleasedState(int x, int y, MapView map) {
        System.out.println("placeholder mouse released, need to be overridden");
    }

    public void mouseDraggedState(int x, int y, MapView map) {
        System.out.println("placeholder mouse dragged, need to be overridden");
    }
}
