package raf.dsw.gerumap.gui.swing.grafika.painter;

import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;

import java.awt.*;

public class PojamPainter extends ElementPainter{

    public PojamPainter(ElementModel elementModel) {
        super(elementModel);
    }

    public PojamPainter(ElementModel element, Shape shape) {
        super(element, shape);
    }

    @Override
    public void draw(Graphics2D g) {
        // crtanje elipse ovde
        g.setPaint(this.getElement().getColor());
        g.setStroke(new BasicStroke(this.getElement().getStroke()));
        g.draw(getShape());
    }
}
