package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.VezaPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class NapraviVezuState extends State {
    private VezaPainter vezaPainter;

    @Override
    public void mousePressedState(int x, int y, MapView map) {
        // ovde postaviti prvi point za liniju
        // objekat na x i y koordinati predstavlja od pojam
        vezaPainter = new VezaPainter(new VezaModel(Color.lightGray, 2, new Point(x, y), new Point(x,y)));
        vezaPainter.setShape(new Line2D.Double(new Point(x, y), new Point(x, y)));
        map.getMapa().addModelAtIndex(vezaPainter.getElement(), 0);
        map.addPainterAtIndex(vezaPainter, 0);
        vezaPainter.getElement().addGrafikaSubscriber(map);
        vezaPainter.getElement().addGrafikaSubscriber(vezaPainter);

    }

    @Override
    public void mouseReleasedState(int x, int y, MapView map) {
        // na samom kraju, ove x i y koordinate postaviti kao krajnju tacku
        // uzeti objekat na x i y koordinati i to ce biti do pojam
        vezaPainter.getElement().setColor(Color.black);
        VezaModel vezaModel = (VezaModel) vezaPainter.getElement();

        PojamPainter pocetniPojam = getPojamPainterAtClickedLocation(vezaModel.getPocetnaTacka(), map);
        PojamPainter krajnjiPojam = getPojamPainterAtClickedLocation(vezaModel.getKrajnjaTacka(), map);

        if (pocetniPojam == null || krajnjiPojam == null) {
            // korisnik nije povezao 2 pojma, izbaciti error
            map.getMapa().removeModel(vezaModel);
            map.removePainter(vezaPainter);
            return;
        }

        PojamModel pocetniPojamModel = (PojamModel) pocetniPojam.getElement();
        PojamModel krajnjiPojamModel = (PojamModel) krajnjiPojam.getElement();

        Ellipse2D pocetnaElipsa = (Ellipse2D) pocetniPojam.getShape();
        Ellipse2D krajnjaElipsa = (Ellipse2D) krajnjiPojam.getShape();

        Point pocetnaTacka = new Point((int) pocetnaElipsa.getCenterX(), (int) pocetnaElipsa.getCenterY());
        Point krajnjaTacka = new Point((int) krajnjaElipsa.getCenterX(), (int) krajnjaElipsa.getCenterY());

        ((VezaModel) vezaPainter.getElement()).setPocetnaTacka(pocetnaTacka);
        ((VezaModel) vezaPainter.getElement()).setKrajnjaTacka(krajnjaTacka);

        vezaPainter.setShape(new Line2D.Double(pocetnaTacka, krajnjaTacka));

        pocetniPojamModel.addOdlazecaVeza(vezaModel);
        krajnjiPojamModel.addDolazecaVeza(vezaModel);
    }

    @Override
    public void mouseDraggedState(int x, int y, MapView map) {
        // za svaki dogadjaj uraditi update da trenutno mesto misa bude drugi point linije
        ((VezaModel) vezaPainter.getElement()).setKrajnjaTacka(new Point(x,y));

        vezaPainter.setShape(new Line2D.Double(((VezaModel) vezaPainter.getElement()).getPocetnaTacka(), new Point(x, y)));

    }
}
