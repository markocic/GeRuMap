package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.PodesavanjaModal;
import raf.dsw.gerumap.logger.TipPoruke;
import raf.dsw.gerumap.state.State;

import java.awt.*;

public class PodesavanjaState extends State {
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        ElementPainter selected = getPainterAtClickedLocation(new Point(x, y), map);
        if (!(selected instanceof PojamPainter)) return;
        String name = ((PojamModel)selected.getElement()).getName();
        Color color = selected.getElement().getColor();
        int stroke = selected.getElement().getStroke();

        boolean viseSelektovanih = map.getSelectedPainters().size() > 1;

        PodesavanjaModal modal = new PodesavanjaModal(MainFrame.getInstance(), name, color, stroke, viseSelektovanih);

        // dalja validacija imena, takodje se preskace ako je selektovano vise elemenata
        if (!viseSelektovanih) {
            while (modal.getName() != null && pojamNameExists(modal.getName(), map) && !modal.getName().equals(name)) {
                AppCore.getInstance().getMsgGenerator().generateMsg("Pojam sa imenom '" + modal.getName() +"' vec postoji", TipPoruke.GRESKA);
                modal.setVisible(true);
            }

        }

        if (!modal.isConfirmed()) return;

        if (viseSelektovanih) multiSelectChange(map, modal.getColor(), modal.getStroke());
        else singleSelectChange(selected, modal.getName(), modal.getColor(), modal.getStroke());

    }

    public void multiSelectChange(MapView map, Color color, int stroke) {
        for (ElementPainter painter : map.getSelectedPainters()) {
            painter.getElement().setColor(color);
            painter.getElement().setStroke(stroke);
        }
    }

    public void singleSelectChange(ElementPainter painter, String name, Color color, int stroke) {
        painter.getElement().setStroke(stroke);
        painter.getElement().setColor(color);
        ((PojamModel) painter.getElement()).setName(name);
    }
}
