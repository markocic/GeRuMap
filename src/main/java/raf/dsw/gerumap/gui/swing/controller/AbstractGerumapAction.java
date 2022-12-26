package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.net.URL;

public abstract class AbstractGerumapAction extends AbstractAction {

    public Icon loadIcon(String fileName){

        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        else {
            System.err.println("Resource not found: " + fileName);
        }
        return icon;
    }

    public void setActive(AbstractGerumapAction action) {
        MainFrame.getInstance().getActionManager().getBrisanjeAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getDodajPojamAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getNapraviVezuAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getPomeranjeAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getSelekcijaAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getZumiranjeAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getPodesavanjaAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getCentralniAction().setEnabled(true);

        if (action == null) return;
        action.setEnabled(false);
    }

    public Project getProjectToSave() {
        MapTreeItem openedNode = ((MapTree) MainFrame.getInstance().getMapTree()).getOpenedNode();
        MapTreeItem selectedNode = MainFrame.getInstance().getMapTree().getSelectedNode();

        Project project = null;
        // postavljamo za projekat prvo otvoreni projekat, ukoliko projekat nije otvoren, onda postavljamo selektovani projekat
        // ukoliko ni projekat nije selektovan onda obavestavamo korisnika da uradi jedno ili drugo
        if (openedNode != null) {
            project = (Project) openedNode.getMapNode();
        } else if (selectedNode != null && selectedNode.getMapNode() instanceof Project) {
            project = (Project) selectedNode.getMapNode();
        }

        return project;
    }

    public MindMap getMapToSave() {
        MapView currentMapView = MainFrame.getInstance().getRightPanel().getCurrentMapView();
        MapTreeItem selectedNode = MainFrame.getInstance().getMapTree().getSelectedNode();

        MindMap mindMap = null;

        if (currentMapView != null) {
            mindMap = currentMapView.getMapa();
        } else if (selectedNode != null && selectedNode.getMapNode() instanceof MindMap) {
            mindMap = (MindMap) selectedNode.getMapNode();
        }

        return mindMap;
    }


}