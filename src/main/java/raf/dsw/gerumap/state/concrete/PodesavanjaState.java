package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.VezaPainter;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.PodesavanjaModal;
import raf.dsw.gerumap.logger.TipPoruke;
import raf.dsw.gerumap.state.State;

import java.awt.*;

public class PodesavanjaState extends State {
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        if (map.getSelectedPainters().isEmpty()) {
            AppCore.getInstance().getMsgGenerator().generateMsg("Morate selektovati elemente koje zelite da menjate", TipPoruke.OBAVJESTENJE);
            return;
        }

        // proveravamo kakva vrsta promena je u pitanju
        boolean singlePojam = map.getSelectedPainters().size() == 1 && map.getSelectedPainters().get(0) instanceof PojamPainter;
        boolean singleVeza = map.getSelectedPainters().size() == 1 && map.getSelectedPainters().get(0) instanceof VezaPainter;
        boolean multiChange = map.getSelectedPainters().size() > 1;

        ElementPainter selected = map.getSelectedPainters().get(0);
        String name = (singlePojam) ? ((PojamModel) selected.getElement()).getName() : null;
        Color color = selected.getElement().getColor();
        int stroke = selected.getElement().getStroke();


        PodesavanjaModal modal = new PodesavanjaModal(MainFrame.getInstance(), name, color, stroke, singlePojam);

        // dalja validacija imena, takodje se preskace ako je selektovano vise elemenata
        if (singlePojam) {
            while (modal.getName() != null && pojamNameExists(modal.getName(), map) && !modal.getName().equals(name)) {
                AppCore.getInstance().getMsgGenerator().generateMsg("Pojam sa imenom '" + modal.getName() +"' vec postoji", TipPoruke.GRESKA);
                modal.setVisible(true);
            }

        }

        if (!modal.isConfirmed()) return;

        if (multiChange) multiSelectChange(map, modal.getColor(), modal.getStroke());
        else if (singlePojam) singlePojamChange(selected, modal.getName(), modal.getColor(), modal.getStroke());
        else singleVezaChange(selected, modal.getColor(), modal.getStroke());

    }

    public void multiSelectChange(MapView map, Color color, int stroke) {
        for (ElementPainter painter : map.getSelectedPainters()) {
            painter.getElement().setColor(color);
            painter.getElement().setStroke(stroke);
        }
    }

    public void singlePojamChange(ElementPainter painter, String name, Color color, int stroke) {
        painter.getElement().setStroke(stroke);
        painter.getElement().setColor(color);
        ((PojamModel) painter.getElement()).setName(name);
    }

    public void singleVezaChange(ElementPainter painter, Color color, int stroke) {
        painter.getElement().setStroke(stroke);
        painter.getElement().setColor(color);
    }
}
