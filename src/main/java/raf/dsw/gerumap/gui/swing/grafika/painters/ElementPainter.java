package raf.dsw.gerumap.gui.swing.grafika.painters;

import raf.dsw.gerumap.gui.swing.grafika.PojamElement;

import java.awt.*;

public abstract class ElementPainter {
    public ElementPainter(PojamElement element){};
    public abstract void paint(Graphics2D grafika,PojamElement element);
    public abstract boolean elementAt(PojamElement element,Point pozicija);
}
