package raf.dsw.gerumap.gui.swing.tree.controller;

import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
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

        if (SelektovaniTreeItem.getMapNode() instanceof MindMap) {
            System.out.println(((MindMap) SelektovaniTreeItem.getMapNode()).getModels());

            for(ElementModel model : (((MindMap) SelektovaniTreeItem.getMapNode()).getModels())) {
                if (model instanceof PojamModel) {
                    System.out.println(((PojamModel) model).getName());
                    System.out.println("odlazece veze: " + ((PojamModel) model).getOdlazeceVeze());
                    System.out.println("dolazece veze: " + ((PojamModel) model).getDolazeceVeze());
                }
                if (model instanceof VezaModel) {
                    System.out.println("VEZA " + model);
                    System.out.println("od pojam: " + ((VezaModel) model).getOdPojma());
                    System.out.println("do pojam: " + ((VezaModel) model).getDoPojma());
                    System.out.println("pocetna tacka: " + ((VezaModel) model).getPocetnaTacka());
                    System.out.println("krajnja tacka: " + ((VezaModel) model).getKrajnjaTacka());
                    System.out.println("subscribers: " + model.getSubscribers());
                }
            }
        }

        ((MapTree)MainFrame.getInstance().getMapTree()).setSelectedNode(SelektovaniTreeItem);
    }
}
