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
        if (selected == null) {
            AppCore.getInstance().getMsgGenerator().generateMsg("Kliknite na selektovani pojam ili vezu koji zelite da obrisete", TipPoruke.OBAVJESTENJE);
            return;
        }

        // provera da je korisnik kliknuo na jedan od selektovanih pojmova
        if (!map.getSelectedPainters().contains(selected)) {
            AppCore.getInstance().getMsgGenerator().generateMsg("Pojam ili veza na koji ste kliknuli nije selektovan", TipPoruke.OBAVJESTENJE);
            return;
        }

        // brisanje svih veza koje su povezane sa selektovanim pojmovima
        for (ElementPainter painter : map.getSelectedPainters()) {
            if (painter instanceof PojamPainter) map.removeAllPainters(getVezePojma(painter, map));
        }

        // brisanje svih selektovanih pojmova sa radne povrsine
        map.deleteSelectedPainters();
    }

}
