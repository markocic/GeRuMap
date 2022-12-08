package raf.dsw.gerumap.gui.swing.grafika.model;

import raf.dsw.gerumap.gui.swing.observer.GrafikaSubscriber;

import java.awt.*;

public class VezaModel extends ElementModel {
    private Point pocetnaTacka;
    private Point krajnjaTacka;

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
