package raf.dsw.gerumap.gui.swing.grafika.model;

public class VezaView extends ElementView{
    private PojamView odPojma;
    private PojamView doPojma;

    public VezaView(int stroke, int color, PojamView odPojma, PojamView doPojma) {
        super(stroke, color);
        this.odPojma = odPojma;
        this.doPojma = doPojma;
    }
}
