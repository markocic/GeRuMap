package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.command.concrete.VezaCommand;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.*;

public class NapraviVezuState extends State {
    private VezaModel vezaModel;
    private AbstractCommand vezaCommand;

    @Override
    public void mousePressedState(int x, int y, MapView map) {
        vezaModel = new VezaModel(Color.lightGray, 2, new Point(x, y), new Point(x,y));
        vezaCommand = new VezaCommand(map.getMapa(), vezaModel);
        map.getMapa().getCommandManager().addCommand(vezaCommand);
    }

    @Override
    public void mouseReleasedState(int x, int y, MapView map) {
        vezaModel.setColor(Color.black);

        PojamPainter pocetniPojam = getPojamPainterAtClickedLocation(vezaModel.getPocetnaTacka(), map);
        PojamPainter krajnjiPojam = getPojamPainterAtClickedLocation(vezaModel.getKrajnjaTacka(), map);

        if (pocetniPojam == null || krajnjiPojam == null) {
            // korisnik nije povezao 2 pojma, izbaciti error
            map.getMapa().getCommandManager().undoCommand();
            return;
        }

        PojamModel pocetniPojamModel = (PojamModel) pocetniPojam.getElement();
        PojamModel krajnjiPojamModel = (PojamModel) krajnjiPojam.getElement();

        ((VezaCommand) vezaCommand).setOdPojam(pocetniPojamModel);
        ((VezaCommand) vezaCommand).setDoPojam(krajnjiPojamModel);
    }

    @Override
    public void mouseDraggedState(int x, int y, MapView map) {
        vezaModel.setKrajnjaTacka(new Point(x,y));
    }
}
