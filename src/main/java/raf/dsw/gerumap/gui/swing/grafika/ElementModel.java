package raf.dsw.gerumap.gui.swing.grafika;

import raf.dsw.gerumap.gui.swing.grafika.painters.ElementPainter;

import java.awt.*;

// publisher
public abstract class ElementModel {
    private Color color;
    private int stroke;

    public ElementModel(Color color, int stroke) {
        this.color = color;
        this.stroke = stroke;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getStroke() {
        return stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }
}
