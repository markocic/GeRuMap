package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.state.State;

import javax.swing.tree.TreeNode;
import java.awt.*;
import java.util.Enumeration;

public class BrisanjeState extends State {
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        ElementPainter selected = getPainterAtClickedLocation(new Point(x, y), map);
        if (!(selected instanceof PojamPainter)) return;

        // brisanje pojma sa radne povrsine
        if (map.getSelectedPainters().contains(selected)) map.deleteSelectedPainters();

        // brisanje pojma iz JTree
        MapTreeItem mindMapTreeItem = getMindMapTreeItem(map.getMapa());
        Enumeration<TreeNode> elements = mindMapTreeItem.children();
        MapTreeItem element;
        while (elements.hasMoreElements()) {
            element = (MapTreeItem) elements.nextElement();
            if (element.getMapNode().getName().equals( ((PojamModel) selected.getElement()).getName())) {
                MainFrame.getInstance().getMapTree().deleteChild(element);
            }
        }
    }

    public MapTreeItem getMindMapTreeItem(MindMap map) {
        Enumeration<TreeNode> children = ((MapTree)MainFrame.getInstance().getMapTree()).getOpenedNode().children();
        MapTreeItem childMap = null;
        while(children.hasMoreElements()) {
            childMap = (MapTreeItem) children.nextElement();
            if (childMap.getMapNode().getName().equals(map.getName())) {
                return childMap;
            }
        }

        return null;
    }
}
