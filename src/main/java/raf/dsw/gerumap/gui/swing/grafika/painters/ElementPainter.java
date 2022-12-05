package raf.dsw.gerumap.gui.swing.grafika.painters;



import raf.dsw.gerumap.gui.swing.grafika.ElementModel;

import java.awt.*;

public abstract class ElementPainter {
    private ElementModel element;
    private Shape shape;

    public void draw(Graphics2D graphics2D) {}

    public boolean elementAt(int x,int y) {
        return shape.contains(x,y);
    };

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
