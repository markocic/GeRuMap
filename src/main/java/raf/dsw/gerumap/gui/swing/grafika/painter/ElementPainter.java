package raf.dsw.gerumap.gui.swing.grafika.painter;



import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;

import java.awt.*;

public abstract class ElementPainter {
    private ElementModel element;
    private Shape shape;

    public ElementPainter(ElementModel elementModel) {
        this.element = elementModel;
    }

    public ElementPainter(ElementModel element, Shape shape) {
        this.element = element;
        this.shape = shape;
    }

    public void draw(Graphics2D g) {}

    public boolean elementAt(Point point) {
        return shape.contains(point);
    }

    public ElementModel getElement() {
        return element;
    }

    public void setElement(ElementModel element) {
        this.element = element;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}