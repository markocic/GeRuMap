package raf.dsw.gerumap.gui.swing.grafika.view;

import java.awt.*;

public class VezaView extends ElementView{
    private PojamView odPojma;
    private PojamView doPojma;

    public VezaView(Color color, int stroke, PojamView odPojma, PojamView doPojma) {
        super(color, stroke);
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
