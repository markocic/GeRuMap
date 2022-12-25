package raf.dsw.gerumap.gui.swing.grafika.model;

import raf.dsw.gerumap.gui.swing.observer.GrafikaSubscriber;

import java.awt.*;

public class VezaModel extends ElementModel {
    private Point pocetnaTacka;
    private Point krajnjaTacka;
    private PojamModel odPojma;
    private PojamModel doPojma;

    public VezaModel(Color color, int stroke, Point pocetnaTacka, Point krajnjaTacka) {
        super(color, stroke);
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
    }

    public Point getPocetnaTacka() {
        return pocetnaTacka;
    }

    public void setPocetnaTacka(Point pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
        notifyShape(pocetnaTacka, krajnjaTacka);
        notifyGrafikaSubscribers(null, null);
    }

    public Point getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public void setKrajnjaTacka(Point krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
        notifyShape(pocetnaTacka, krajnjaTacka);
        notifyGrafikaSubscribers(null, null);
    }


    @Override
    public void notifyShape(Object pocetnaTacka, Object krajnjaTacka) {
        if (pocetnaTacka == null || krajnjaTacka == null) return;
        for (GrafikaSubscriber sub : getSubscribers()) {
            sub.updateShape(pocetnaTacka, krajnjaTacka);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof VezaModel veza)) return false;

        return veza.krajnjaTacka.equals(this.krajnjaTacka) && veza.pocetnaTacka.equals(this.pocetnaTacka);
    }

    public PojamModel getOdPojma() {
        return odPojma;
    }

    public void setOdPojma(PojamModel odPojma) {
        this.odPojma = odPojma;
        notifyGrafikaSubscribers(null, null);
    }

    public PojamModel getDoPojma() {
        return doPojma;
    }

    public void setDoPojma(PojamModel doPojma) {
        this.doPojma = doPojma;
        notifyGrafikaSubscribers(null, null);
    }
}
