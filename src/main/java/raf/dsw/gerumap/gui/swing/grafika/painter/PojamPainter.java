package raf.dsw.gerumap.gui.swing.grafika.painter;

import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.state.concrete.DodajPojamState;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class PojamPainter extends ElementPainter{

    public PojamPainter(ElementModel elementModel) {
        super(elementModel);
    }

    public PojamPainter(ElementModel element, Shape shape) {
        super(element, shape);
    }

    @Override
    public void draw(Graphics2D g) {
        // postavljamo boju
        if (getElement().getCustomColor() != null && !isSelected()) g.setPaint(this.getElement().getCustomColor());
        else g.setPaint(getElement().getColor());
        // debljina linije
        g.setStroke(new BasicStroke(this.getElement().getStroke()));

        PojamModel pojam = ((PojamModel) getElement());
        String name = pojam.getName();
        // racunamo velicinu elipse na osnovu imena
        pojam.setSize(getSizeBasedOnText(g, name));
        setShape(new Ellipse2D.Double(pojam.getCoordinates().getX(), pojam.getCoordinates().getY(), pojam.getSize().getWidth(), pojam.getSize().getHeight()));
        drawCenteredString(g, name);
        g.draw(getShape());
    }

    public void drawCenteredString(Graphics2D g, String text) {
        PojamModel element = (PojamModel) getElement();
        FontMetrics metrics = g.getFontMetrics();
        int x = (int) (element.getCoordinates().getX() + (element.getSize().getWidth() - metrics.stringWidth(text)) / 2);
        int y = (int) (element.getCoordinates().getY() + ((element.getSize().getHeight() - metrics.getHeight()) / 2) + metrics.getAscent());
        g.drawString(text, x, y);
    }

    public Dimension getSizeBasedOnText(Graphics2D g, String text) {
        FontMetrics metrics = g.getFontMetrics();
        int width = metrics.stringWidth(text) + 30;
        int height = metrics.getHeight() * 2;

        return new Dimension(width, height);
    }
}
