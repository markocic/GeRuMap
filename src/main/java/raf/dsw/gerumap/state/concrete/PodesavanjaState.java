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
        PodesavanjaModal modal = new PodesavanjaModal(MainFrame.getInstance(), name, color, stroke);

        while (modal.getName() != null && pojamNameExists(modal.getName(), map) && !modal.getName().equals(name)) {
            AppCore.getInstance().getMsgGenerator().generateMsg("Pojam sa imenom '" + modal.getName() +"' vec postoji", TipPoruke.GRESKA);
            modal.setVisible(true);
        }

        if (modal.isConfirmed()) {
            selected.getElement().setColor(modal.getColor());
            selected.getElement().setStroke(modal.getStroke());
            ((PojamModel) selected.getElement()).setName(modal.getName());
        }

        map.repaint();

    }
}
