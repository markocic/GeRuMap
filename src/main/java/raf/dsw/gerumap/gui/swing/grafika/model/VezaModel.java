package raf.dsw.gerumap.gui.swing.grafika.model;

import raf.dsw.gerumap.gui.swing.observer.GrafikaSubscriber;

import java.awt.*;

public class VezaModel extends ElementModel {
    private Point pocetnaTacka;
    private Point krajnjaTacka;
    private PojamModel odPojma;
    private PojamModel doPojma;

    public VezaModel(Color color, int stroke, PojamModel odPojma, PojamModel doPojma) {
        super(color, stroke);
        this.odPojma = odPojma;
        this.doPojma = doPojma;
    }

    public VezaModel(Color color, int stroke, Point pocetnaTacka, Point krajnjaTacka) {
        super(color, stroke);
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
    }

    public PojamModel getOdPojma() {
        return odPojma;
    }

    public void setOdPojma(PojamModel odPojma) {
        this.odPojma = odPojma;
        notifyGrafikaSubscribers();
    }

    public PojamModel getDoPojma() {
        return doPojma;
    }

    public void setDoPojma(PojamModel doPojma) {
        this.doPojma = doPojma;
        notifyGrafikaSubscribers();
    }

    public Point getPocetnaTacka() {
        return pocetnaTacka;
    }

    public void setPocetnaTacka(Point pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
        notifyGrafikaSubscribers();
    }

    public Point getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public void setKrajnjaTacka(Point krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
        notifyGrafikaSubscribers();
    }
}
