package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.logger.TipPoruke;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.state.State;

import javax.swing.*;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Enumeration;

public class DodajPojamState extends State {
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        // ne dozvoljava korisniku da napravi "blank" pojam
        String pojamName = "";
        boolean check = true;
        do {
            pojamName = JOptionPane.showInputDialog("Unesi ime novog pojma: ","Novi pojam");
            if (pojamName.isBlank()) {
                AppCore.getInstance().getMsgGenerator().generateMsg("Ime ne moze da bude prazno", TipPoruke.GRESKA);
            }
            else check = false;

        } while (check);

        PojamModel pojamModel = new PojamModel(pojamName, new Point(x, y), new Dimension(80, 40), 2, Color.BLACK);
        PojamPainter pojamPainter = new PojamPainter(pojamModel);
        map.addPainter(pojamPainter);
    }

}
