package raf.dsw.gerumap.gui.swing.grafika.painters;

import raf.dsw.gerumap.gui.swing.grafika.PojamElement;

import java.awt.*;

public class OblikPainter extends ElementPainter{


    public OblikPainter(PojamElement element) {
        super(element);
    }

    @Override
    public void paint(Graphics2D grafika, PojamElement element) {

    }

    @Override
    public boolean elementAt(PojamElement element, Point pozicija) {
        return false;
    }
}
