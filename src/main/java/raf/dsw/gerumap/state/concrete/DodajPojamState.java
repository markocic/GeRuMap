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
    public String s;
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        s = JOptionPane.showInputDialog("Unesi ime novog pojma: ","Novi pojam");
        System.out.println(s);
        // pravljenje novog objekta instance Element i povezivanje sa mapom
        Enumeration<TreeNode> children = ((MapTree)MainFrame.getInstance().getMapTree()).getOpenedNode().children();
        MapTreeItem childMap = null;
        while(children.hasMoreElements()) {
            childMap = (MapTreeItem) children.nextElement();
            if (childMap.getMapNode().getName().equals(map.getMapa().getName())) {
                // nasli smo mapu, dodajemo joj dete
                MainFrame.getInstance().getMapTree().addChild(childMap);
            }
        }
        //treba ga ubaciti da se crta unutar elipse i pojavljuje u project view
        // TODO: treba dodati da pita za naziv elementa, taj naziv ispisati unutar elementa i postaviti to ime u project exploreru levo.
        PojamModel pojamModel = new PojamModel(s, new Point(x, y), new Dimension(80, 40), 2, Color.BLACK);
        Ellipse2D elipsa = new Ellipse2D.Double(pojamModel.getCoordinates().getX(), pojamModel.getCoordinates().getY(), pojamModel.getSize().getWidth(), pojamModel.getSize().getHeight());
        PojamPainter pojamPainter = new PojamPainter(pojamModel, elipsa);
        map.addPainter(pojamPainter);
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
