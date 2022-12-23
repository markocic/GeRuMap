package raf.dsw.gerumap.gui.swing.grafika.painter;



import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.observer.GrafikaSubscriber;

import java.awt.*;

public abstract class ElementPainter implements GrafikaSubscriber {
    private ElementModel element;
    private Shape shape;

    private boolean selected;

    public ElementPainter(ElementModel elementModel) {
        this.element = elementModel;
    }

    public ElementPainter(ElementModel element, Shape shape) {
        this.element = element;
        this.shape = shape;
        this.selected = false;
    }

    public void draw(Graphics2D g) {}

    public boolean elementAt(Point point) {
        if (shape == null) return false;
        return shape.contains(point) || shape.getBounds().contains(point);
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
