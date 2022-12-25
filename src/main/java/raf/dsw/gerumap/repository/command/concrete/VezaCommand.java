package raf.dsw.gerumap.repository.command.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.implementation.MindMap;

import java.awt.*;

public class VezaCommand extends AbstractCommand {

    private MindMap mindMap;
    private VezaModel vezaModel;

    private PojamModel odPojam;
    private PojamModel doPojam;

    public VezaCommand(MindMap mindMap, VezaModel vezaModel) {
        this.mindMap = mindMap;
        this.vezaModel = vezaModel;
    }

    @Override
    public void doCommand() {
        mindMap.addModelAtIndex(vezaModel, 0);
        updateOdPojam();
        updateDoPojam();
    }

    @Override
    public void undoCommand() {
        mindMap.removeModel(vezaModel);
    }

    public PojamModel getOdPojam() {
        return odPojam;
    }

    public void setOdPojam(PojamModel odPojam) {
        this.odPojam = odPojam;
        updateOdPojam();
    }

    public PojamModel getDoPojam() {
        return doPojam;
    }

    public void setDoPojam(PojamModel doPojam) {
        this.doPojam = doPojam;
        updateDoPojam();
    }

    public void updateDoPojam() {
        if (doPojam == null) return;

        vezaModel.setDoPojma(doPojam);
        doPojam.addDolazecaVeza(vezaModel);

        int x = doPojam.getCoordinates().x;
        int y = doPojam.getCoordinates().y;

        int pojamWidth = doPojam.getSize().width;
        int pojamHeight = doPojam.getSize().height;

        vezaModel.setKrajnjaTacka(new Point(x + pojamWidth / 2, y + pojamHeight / 2));
    }

    public void updateOdPojam() {
        if (odPojam == null) return;
        vezaModel.setOdPojma(odPojam);
        odPojam.addOdlazecaVeza(vezaModel);

        int x = odPojam.getCoordinates().x;
        int y = odPojam.getCoordinates().y;

        int pojamWidth = odPojam.getSize().width;
        int pojamHeight = odPojam.getSize().height;

        vezaModel.setPocetnaTacka(new Point(x + pojamWidth / 2, y + pojamHeight / 2));
    }
}
