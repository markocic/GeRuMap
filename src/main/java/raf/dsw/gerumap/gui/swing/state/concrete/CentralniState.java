package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.state.State;
import raf.dsw.gerumap.gui.swing.view.MapView;

import java.awt.*;
import java.util.ArrayList;

public class CentralniState extends State {

    private ArrayList<PojamModel> visited = new ArrayList<>();
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        PojamPainter pojamPainter = getPojamPainterAtClickedLocation(new Point(x, y), map);

        PojamModel pojamModel = ((PojamModel) pojamPainter.getElement());

        if (map.getMapa().getCentralniPojam() != null) {
            map.getMapa().getCentralniPojam().setCentralni(false);
        }

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
            if (!((PojamModel) model).isCentralni() && ((PojamModel) model).getLevel() == 0) continue;

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
            if (!pojamM.isCentralni() && pojamM.getLevel() == 0) continue;

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
        if (level > size || visited.contains(pojam)) return;
        pojam.setLevel(++level);
        visited.add(pojam);

        for (VezaModel veza : pojam.getOdlazeceVeze()) {
            setPojamLevel(veza.getDoPojma(), level, size);
        }

        for (VezaModel veza : pojam.getDolazeceVeze()) {
            setPojamLevel(veza.getOdPojma(), level, size);
        }
    }
}
