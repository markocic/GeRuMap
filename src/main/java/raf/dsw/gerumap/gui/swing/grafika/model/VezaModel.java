package raf.dsw.gerumap.gui.swing.grafika.model;

import java.awt.*;

public class VezaModel extends ElementModel {
    private PojamModel odPojma;
    private PojamModel doPojma;

    public VezaModel(Color color, int stroke, PojamModel odPojma, PojamModel doPojma) {
        super(color, stroke);
        this.odPojma = odPojma;
        this.doPojma = doPojma;
    }

    public PojamModel getOdPojma() {
        return odPojma;
    }

    public void setOdPojma(PojamModel odPojma) {
        this.odPojma = odPojma;
    }

    public PojamModel getDoPojma() {
        return doPojma;
    }

    public void setDoPojma(PojamModel doPojma) {
        this.doPojma = doPojma;
    }
}
