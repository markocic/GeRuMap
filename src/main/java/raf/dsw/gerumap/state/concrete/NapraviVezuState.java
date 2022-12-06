package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.VezaPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.state.State;

public class NapraviVezuState extends State {

    @Override
    public void mousePressedState(int x, int y, MapView map) {
        // ovde postaviti prvi point za liniju
        // objekat na x i y koordinati predstavlja od pojam


    }

    @Override
    public void mouseReleasedState(int x, int y, MapView map) {
        // na samom kraju, ove x i y koordinate postaviti kao krajnju tacku
        // uzeti objekat na x i y koordinati i to ce biti do pojam
    }

    @Override
    public void mouseDraggedState(int x, int y, MapView map) {
        // za svaki dogadjaj uraditi update da trenutno mesto misa bude drugi point linije
    }
}
