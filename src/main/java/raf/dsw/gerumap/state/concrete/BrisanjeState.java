package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.state.State;

public class BrisanjeState extends State {
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        // ne svidja mi se kako trenutno radi, UX je los
        // moze se staviti da kad se aktivira brisanje state, klikom na elemente korisnik moze da obrise taj element
        map.deleteSelectedPainters();
    }
}
