package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.VezaPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.logger.TipPoruke;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.util.ArrayList;

public class BrisanjeState extends State {
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        ElementPainter selected = getPainterAtClickedLocation(new Point(x, y), map);
        if (!(selected instanceof PojamPainter)) {
            AppCore.getInstance().getMsgGenerator().generateMsg("Kliknite na selektovani pojam koji zelite da obrisete", TipPoruke.OBAVJESTENJE);
            return;
        }

        // brisanje pojma sa radne povrsine
        if (map.getSelectedPainters().contains(selected)) map.deleteSelectedPainters();
        else {
            AppCore.getInstance().getMsgGenerator().generateMsg("Pojam na koji ste kliknuli nije selektovan", TipPoruke.OBAVJESTENJE);
            return;
        }

        // brisanje veza koje su povezane sa pojmom koji brisemo
        ArrayList<ElementPainter> vezaPainterList = new ArrayList<>();
        for (ElementPainter painter : map.getPainters()) {
            if (painter instanceof VezaPainter) {
                VezaModel vezaModel = (VezaModel) painter.getElement();
                if (vezaModel.getOdPojma().equals(selected.getElement()) || vezaModel.getDoPojma().equals(selected.getElement())) {
                    vezaPainterList.add(painter);
                }
            }
        }

        map.removeAllPainters(vezaPainterList);
    }

}
