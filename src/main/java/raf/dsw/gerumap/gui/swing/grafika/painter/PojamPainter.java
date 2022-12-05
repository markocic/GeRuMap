package raf.dsw.gerumap.gui.swing.grafika.painter;

import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.state.concrete.DodajPojamState;

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
        drawCenteredString(g, ((PojamModel) getElement()).getName());
        g.draw(getShape());
    }

    public void drawCenteredString(Graphics2D g, String text) {
        PojamModel element = (PojamModel) getElement();
        FontMetrics metrics = g.getFontMetrics();
        int x = (int) (element.getCoordinates().getX() + (element.getSize().getWidth() - metrics.stringWidth(text)) / 2);
        int y = (int) (element.getCoordinates().getY() + ((element.getSize().getHeight() - metrics.getHeight()) / 2) + metrics.getAscent());
        g.drawString(text, x, y);
    }
}
