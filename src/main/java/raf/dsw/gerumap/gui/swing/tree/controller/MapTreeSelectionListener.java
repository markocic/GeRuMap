package raf.dsw.gerumap.gui.swing.tree.controller;

import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class MapTreeSelectionListener implements TreeSelectionListener {
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath put = e.getPath();
        MapTreeItem SelektovaniTreeItem = (MapTreeItem) put.getLastPathComponent();
        System.out.println("Izabrani cvor:" + SelektovaniTreeItem.getMapNode().getName());
        System.out.println("getPath: " + e.getPath());
        ((MapTree)MainFrame.getInstance().getMapTree()).setSelectedNode(SelektovaniTreeItem);
    }
}
