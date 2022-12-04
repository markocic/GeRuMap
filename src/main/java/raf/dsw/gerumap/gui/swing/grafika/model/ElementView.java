package raf.dsw.gerumap.gui.swing.grafika.model;

public class ElementView {
    int stroke;
    int color;

    public ElementView(int stroke, int color) {
        this.stroke = stroke;
        this.color = color;
    }

    public int getStroke() {
        return stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
