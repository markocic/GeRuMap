package raf.dsw.gerumap.gui.swing.grafika.model;

import java.awt.*;

public class ElementView {
    int stroke;
    Color color;

    public ElementView(int stroke, Color color) {
        this.stroke = stroke;
        this.color = color;
    }

    public int getStroke() {
        return stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
       this.color = color;
    }
}
