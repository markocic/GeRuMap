package raf.dsw.gerumap.gui.swing.grafika.model;

import java.awt.*;

public class VezaView extends ElementView{
    private PojamView odPojma;
    private PojamView doPojma;

    public VezaView(int stroke, Color color, PojamView odPojma, PojamView doPojma) {
        super(stroke, color);
        this.odPojma = odPojma;
        this.doPojma = doPojma;
    }

    public PojamView getOdPojma() {
        return odPojma;
    }

    public void setOdPojma(PojamView odPojma) {
        this.odPojma = odPojma;
    }

    public PojamView getDoPojma() {
        return doPojma;
    }

    public void setDoPojma(PojamView doPojma) {
        this.doPojma = doPojma;
    }
}
