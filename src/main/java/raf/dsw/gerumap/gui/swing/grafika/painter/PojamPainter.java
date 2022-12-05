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
        g.drawString(((PojamModel)getElement()).getName(),((PojamModel) getElement()).getCoordinates().x + 10,((PojamModel) getElement()).getCoordinates().y+((PojamModel) getElement()).getSize().height/2);
        g.draw(getShape());
    }
}
