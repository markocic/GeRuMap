package raf.dsw.gerumap.gui.swing.tree.controller;

import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.implementation.MindMap;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class MapTreeSelectionListener implements TreeSelectionListener {
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath put = e.getPath();
        MapTreeItem SelektovaniTreeItem = (MapTreeItem) put.getLastPathComponent();
        // println koji pomaze prilikom debagovanja, vratiti po potrebi, za sad u komentaru
//        System.out.println("Izabrani cvor:" + SelektovaniTreeItem.getMapNode().getName() + "\ntip podatka je: " + SelektovaniTreeItem.getMapNode().getClass());
//        System.out.println("getPath: " + e.getPath());

        // kod koji ispisuje trenutnog autora, debugging reasons only, obrisati posle u "produkciji"
//        if (SelektovaniTreeItem.getMapNode() instanceof Project) {
//            System.out.println(((Project) SelektovaniTreeItem.getMapNode()).getAuthor());
//        }
        if (SelektovaniTreeItem.getMapNode() instanceof MindMap) {
            System.out.println(((MindMap) SelektovaniTreeItem.getMapNode()).getModels());

            for(ElementModel model : (((MindMap) SelektovaniTreeItem.getMapNode()).getModels())) {
                if (model instanceof PojamModel) {
                    System.out.println(((PojamModel) model).getName());
                    System.out.println(((PojamModel) model).getOdlazeceVeze());
                    System.out.println(((PojamModel) model).getDolazeceVeze());
                }
            }
        }

        ((MapTree)MainFrame.getInstance().getMapTree()).setSelectedNode(SelektovaniTreeItem);
    }
}
