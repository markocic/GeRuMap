package raf.dsw.gerumap.gui.swing.tree.controller;

import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.logger.ConsoleLogger;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class MapTreeSelectionListener implements TreeSelectionListener {
    ConsoleLogger consoleLogger;
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath put = e.getPath();
        MapTreeItem SelektovaniTreeItem = (MapTreeItem) put.getLastPathComponent();
        System.out.println("Izabrani cvor:" + SelektovaniTreeItem.getMapNode().getName() + "\ntip podatka je: " + SelektovaniTreeItem.getMapNode().getClass());
        System.out.println("getPath: " + e.getPath());

        // kod koji ispisuje trenutnog autora, debugging reasons only, obrisati posle u "produkciji"
        if (SelektovaniTreeItem.getMapNode() instanceof Project) {
            System.out.println(((Project) SelektovaniTreeItem.getMapNode()).getAuthor());
        }

        ((MapTree)MainFrame.getInstance().getMapTree()).setSelectedNode(SelektovaniTreeItem);
    }
}
