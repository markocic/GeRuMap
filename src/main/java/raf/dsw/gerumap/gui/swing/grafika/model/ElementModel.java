package raf.dsw.gerumap.gui.swing.grafika.model;

import java.awt.*;

// publisher
public abstract class ElementModel {
    private Color color;
    private Color customColor;
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

    public Color getCustomColor() {
        return customColor;
    }

    public void setCustomColor(Color customColor) {
        this.customColor = customColor;
    }
}
