package raf.dsw.gerumap.gui.swing.grafika.painter;

import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;

import java.awt.*;

public class VezaPainter extends ElementPainter{

    public VezaPainter(ElementModel elementModel) {
        super(elementModel);
    }
    @Override
    public void draw(Graphics2D g) {
            VezaModel vezaModel = (VezaModel) getElement();
            g.setStroke(new BasicStroke(vezaModel.getStroke()));
            g.setColor(vezaModel.getColor());
            g.drawLine((int) vezaModel.getPocetnaTacka().getX(), (int) vezaModel.getPocetnaTacka().getY(),
                    (int) vezaModel.getKrajnjaTacka().getX(), (int) vezaModel.getKrajnjaTacka().getY());
    }
}
