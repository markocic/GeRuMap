package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.VezaPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.command.concrete.VezaCommand;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class NapraviVezuState extends State {
    private VezaPainter vezaPainter;
    private VezaModel vezaModel;

    @Override
    public void mousePressedState(int x, int y, MapView map) {
        vezaModel = new VezaModel(Color.lightGray, 2, new Point(x, y), new Point(x,y));
        AbstractCommand vezaCommand = new VezaCommand(map.getMapa(), vezaModel);
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

        Ellipse2D pocetnaElipsa = (Ellipse2D) pocetniPojam.getShape();
        Ellipse2D krajnjaElipsa = (Ellipse2D) krajnjiPojam.getShape();

        Point pocetnaTacka = new Point((int) pocetnaElipsa.getCenterX(), (int) pocetnaElipsa.getCenterY());
        Point krajnjaTacka = new Point((int) krajnjaElipsa.getCenterX(), (int) krajnjaElipsa.getCenterY());

        vezaModel.setPocetnaTacka(pocetnaTacka);
        vezaModel.setKrajnjaTacka(krajnjaTacka);

        pocetniPojamModel.addOdlazecaVeza(vezaModel);
        krajnjiPojamModel.addDolazecaVeza(vezaModel);
    }

    @Override
    public void mouseDraggedState(int x, int y, MapView map) {
        vezaModel.setKrajnjaTacka(new Point(x,y));
    }
}
