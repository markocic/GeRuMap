package raf.dsw.gerumap.gui.swing.grafika.painter;

import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.repository.command.CommandType;

import java.awt.*;
import java.awt.geom.Line2D;

public class VezaPainter extends ElementPainter {

    public VezaPainter(ElementModel elementModel) {
        super(elementModel);
        Line2D line = new Line2D.Double(((VezaModel) elementModel).getPocetnaTacka(), ((VezaModel) elementModel).getKrajnjaTacka());
        elementModel.addGrafikaSubscriber(this);
        setShape(line);
    }
    @Override
    public void draw(Graphics2D g) {
            VezaModel vezaModel = (VezaModel) getElement();
            g.setStroke(new BasicStroke(vezaModel.getStroke()));
            if (isSelected()) g.setColor(Color.RED);
            else g.setColor(vezaModel.getColor());
            g.draw(getShape());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof VezaPainter)) return false;
        VezaModel vezaModel = (VezaModel) ((VezaPainter) obj).getElement();
        // 2 veza paintera su jednaka ako njihovi modeli imaju jednake krajnje i pocetne tacke (povezuju iste pojmove)
        return vezaModel.getPocetnaTacka().equals(((VezaModel) this.getElement()).getPocetnaTacka())
                && vezaModel.getKrajnjaTacka().equals(((VezaModel) this.getElement()).getKrajnjaTacka());
    }

    @Override
    public void updateShape(Object pocetnaTacka, Object krajnjaTacka) {
        setShape(new Line2D.Double((Point) pocetnaTacka, (Point) krajnjaTacka));
    }

    @Override
    public void update(CommandType commandType, Object obj) {}
}
