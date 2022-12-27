package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.VezaPainter;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.PodesavanjaModal;
import raf.dsw.gerumap.logger.TipPoruke;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.*;
import java.awt.geom.Ellipse2D;

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
        boolean isCentralni = singlePojam && ((PojamModel) selected.getElement()).isCentralni();
        Color color = selected.getElement().getColor();
        int stroke = selected.getElement().getStroke();


        PodesavanjaModal modal = new PodesavanjaModal(MainFrame.getInstance(), name, color, stroke, singlePojam, isCentralni);

        // dalja validacija imena, takodje se preskace ako je selektovano vise elemenata
        if (singlePojam) {
            while (modal.getName() != null && pojamNameExists(modal.getName(), map) && !modal.getName().equals(name)) {
                AppCore.getInstance().getMsgGenerator().generateMsg("Pojam sa imenom '" + modal.getName() +"' vec postoji", TipPoruke.GRESKA);
                modal.setVisible(true);
            }

        }

        if (!modal.isConfirmed()) return;

        if (multiChange) multiSelectChange(map, modal.getColor(), modal.getStroke());
        else if (singlePojam) singlePojamChange(map, selected, modal.getName(), modal.getColor(), modal.getStroke(), modal.isCentralni());
        else singleVezaChange(selected, modal.getColor(), modal.getStroke());

    }

    public void multiSelectChange(MapView map, Color color, int stroke) {
        for (ElementPainter painter : map.getSelectedPainters()) {
            painter.getElement().setColor(color);
            painter.getElement().setStroke(stroke);
        }
    }

    public void singlePojamChange(MapView map, ElementPainter painter, String name, Color color, int stroke, boolean isCentralni) {
        PojamModel pojam = (PojamModel) painter.getElement();
        pojam.setStroke(stroke);
        pojam.setColor(color);
        pojam.setName(name);
        pojam.setCentralni(isCentralni);
        if (isCentralni) {
            Point newPoint = new Point((int) ((map.getWidth() - pojam.getSize().getWidth()) / 2), (int) ((map.getHeight() - pojam.getSize().getHeight()) / 2));

            pojam.setCoordinates(newPoint);

            Ellipse2D elipsa = (Ellipse2D) painter.getShape();
            elipsa.setFrame(newPoint, pojam.getSize());

            pojam.updateVeze(new Point((int) elipsa.getCenterX(), (int) elipsa.getCenterY()));
        }
    }

    public void singleVezaChange(ElementPainter painter, Color color, int stroke) {
        painter.getElement().setStroke(stroke);
        painter.getElement().setColor(color);
    }
}
