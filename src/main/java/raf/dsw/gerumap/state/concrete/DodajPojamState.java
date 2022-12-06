package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
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
        String pojamName = JOptionPane.showInputDialog("Unesi ime novog pojma: ","Novi pojam");
        System.out.println(pojamName);
        // izgleda da ne moraju elementi da se reflektuju u JTree tako da sam dosta vremena bacio u vodu al bar necu morati jos koji sat :)
//        // pravljenje novog objekta instance Element i povezivanje sa mapom
//        Enumeration<TreeNode> children = ((MapTree)MainFrame.getInstance().getMapTree()).getOpenedNode().children();
//        MapTreeItem childMap = null;
//        while(children.hasMoreElements()) {
//            childMap = (MapTreeItem) children.nextElement();
//            if (childMap.getMapNode().getName().equals(map.getMapa().getName())) {
//                // nasli smo mapu, dodajemo joj dete
//                // TODO implementirati proveru da li odabrano ime vec postoji kao element u mapi
//                MainFrame.getInstance().getMapTree().addChild(childMap, pojamName);
//            }
//        }
        PojamModel pojamModel = new PojamModel(pojamName, new Point(x, y), new Dimension(80, 40), 2, Color.BLACK);
        PojamPainter pojamPainter = new PojamPainter(pojamModel);
        map.addPainter(pojamPainter);
    }

}
