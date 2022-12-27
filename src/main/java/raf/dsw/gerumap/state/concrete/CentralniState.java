package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.util.Arrays;

public class CentralniState extends State {
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        PojamPainter pojamPainter = getPojamPainterAtClickedLocation(new Point(x, y), map);

        PojamModel pojamModel = ((PojamModel) pojamPainter.getElement());

        pojamModel.setCentralni(true);
        map.getMapa().setCentralniPojam(pojamModel);

        int level = -1;

        setPojamLevel(pojamModel, level, map.getMapa().getModels().size());

        int[] leviNivoCount = new int[map.getMapa().getModels().size()];
        int[] leviNivoCount2 = new int[map.getMapa().getModels().size()];
        int[] desniNivoCount = new int[map.getMapa().getModels().size()];
        int[] desniNivoCount2 = new int[map.getMapa().getModels().size()];

        boolean temp = true;

        for (VezaModel veza : pojamModel.getOdlazeceVeze()) {

            if (temp) {
                mrdniLevo(veza.getDoPojma());
            }
            temp = !temp;
        }

        for (ElementModel model : map.getMapa().getModels()) {
            if (model instanceof VezaModel) continue;
            if (((PojamModel) model).getStrana() == -1) {
                leviNivoCount[((PojamModel) model).getLevel()] += 1;
                leviNivoCount2[((PojamModel) model).getLevel()] += 1;
            } else {
                desniNivoCount[((PojamModel) model).getLevel()] += 1;
                desniNivoCount2[((PojamModel) model).getLevel()] += 1;
            }
        }



        for (ElementModel model : map.getMapa().getModels()) {
            if (model instanceof VezaModel) continue;

            PojamModel pojamM = (PojamModel) model;

            int xPoint = 0, yPoint = 0;

            if (pojamM.getStrana() == -1) {
                // leva strana
                int yOffset = map.getHeight() / (leviNivoCount[pojamM.getLevel()] + 1);

                xPoint = map.getWidth() / 2 + 100 * pojamM.getLevel() * pojamM.getStrana();
                yPoint = yOffset * leviNivoCount2[pojamM.getLevel()];
                leviNivoCount2[pojamM.getLevel()] -= 1;
            } else {
                int yOffset = map.getHeight() / (desniNivoCount[pojamM.getLevel()] + 1);

                xPoint = map.getWidth() / 2 + 100 * pojamM.getLevel() * pojamM.getStrana();
                yPoint = yOffset * desniNivoCount2[pojamM.getLevel()];
                desniNivoCount2[pojamM.getLevel()] -= 1;
            }

            Point newPoint = new Point(xPoint, yPoint);
            pojamM.setCoordinates(newPoint);
        }

    }

    private void mrdniLevo(PojamModel pojam) {

        pojam.setStrana(-1);

        for (VezaModel veza : pojam.getOdlazeceVeze()) {
            mrdniLevo(veza.getDoPojma());
        }
    }

    public void setPojamLevel(PojamModel pojam, int level, int size) {
        if (level > size) return;
        pojam.setLevel(++level);

        for (VezaModel veza : pojam.getOdlazeceVeze()) {
            setPojamLevel(veza.getDoPojma(), level, size);
        }
    }
}
