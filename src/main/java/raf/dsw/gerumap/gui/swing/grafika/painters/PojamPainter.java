package raf.dsw.gerumap.gui.swing.grafika.painters;

import java.awt.*;

public class PojamPainter extends ElementPainter{
    public PojamPainter() {
        super();
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(element.getColor());
        graphics.setStroke(new BasicStroke(element.getStroke()));
        graphics.draw(shape);
    }

    @Override
    public boolean elementAt(int x, int y) {
        return shape.contains(x,y);
    }





}
