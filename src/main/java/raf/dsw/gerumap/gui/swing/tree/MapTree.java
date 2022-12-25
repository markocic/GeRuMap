package raf.dsw.gerumap.gui.swing.tree;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.core.IMapTree;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.logger.TipPoruke;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;
import raf.dsw.gerumap.repository.factory.FactoryUtils;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.List;

public class MapTree implements IMapTree {

    private MapTreeView treeView;
    private DefaultTreeModel treeModel;

    private MapTreeItem selectedNode;
    private MapTreeItem openedNode;


    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addChild(MapTreeItem parent, String name) {
        if(!((parent.getMapNode()) instanceof MapNodeComposite))return;

        MapNode child = createChild(parent.getMapNode());
        if (child.getParent() instanceof Project && openedNode != null &&child.getParent() == openedNode.getMapNode()) {
            child.addSubscriber(MainFrame.getInstance().getRightPanel());
        }
        if (name != null) child.setName(name);
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);

    }

    @Override
    public void deleteChild(MapTreeItem child) {
        if(!((child.getMapNode().getParent()) instanceof MapNodeComposite))return;

        if (child.getMapNode().getParent() instanceof Project) {
            // ako brisemo mapu
            Project parent = (Project) child.getMapNode().getParent();
            child.getMapNode().notifyMindMapDeleted(child.getMapNode().getName());
            parent.deleteChild(child.getMapNode());
        }

        if (child.getMapNode() instanceof Project) {
            // ako brisemo projekat
            if (this.openedNode == child) {
                child.getMapNode().notifyOpenedProjectDeleted();
            }
        }

        child.removeFromParent();
        this.selectedNode = null;
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    public void openSelectedNode() {
        // ukoliko je prethodno bio otvoren projekat, sklanjamo njega i svu njegovu decu kao subskrajbere
        if (!(this.openedNode == null)) {
            this.openedNode.getMapNode().removeSubscriber(MainFrame.getInstance().getRightPanel());

            List<MapNode> children = ((Project)this.openedNode.getMapNode()).getChildren();
            for (MapNode child: children) {
                child.removeSubscriber(MainFrame.getInstance().getRightPanel());
            }
        }

        // postavljamo novi otvoreni projekat i njega i svu njegovu decu postavljamo kao subskrajbere

        if (selectedNode.getMapNode() instanceof Project) {
            this.openedNode = selectedNode;
        } else if (selectedNode.getMapNode() instanceof MindMap) {
            this.openedNode = (MapTreeItem) selectedNode.getParent();
        } else if (selectedNode.getMapNode() instanceof Element) {
            this.openedNode = (MapTreeItem) selectedNode.getParent().getParent();
        } else {
            AppCore.getInstance().getMsgGenerator().generateMsg("Morate selektovati projekat ili mapu koju zelite da otvorite", TipPoruke.GRESKA);
            return;
        }

        this.openedNode.getMapNode().addSubscriber(MainFrame.getInstance().getRightPanel());

        List<MapNode> children = ((Project)this.openedNode.getMapNode()).getChildren();
        for (MapNode child: children) {
            child.addSubscriber(MainFrame.getInstance().getRightPanel());
        }
        this.openedNode.getMapNode().notifyProjectOpened(this.openedNode.getMapNode());
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(MapTreeItem selectedNode) {
        this.selectedNode = selectedNode;
    }



    public MapNode createChild(MapNode parent){
        return new FactoryUtils().getFactory(parent).getNode(parent);
    }

    public MapTreeItem getOpenedNode() {
        return openedNode;
    }

    public void setOpenedNode(MapTreeItem openedNode) {
        this.openedNode = openedNode;
    }

    public void loadProject(Project project) {
        project.setParent(((MapTreeItem) treeModel.getRoot()).getMapNode());
        MapTreeItem loadedProject = new MapTreeItem(project);
        ((MapTreeItem) treeModel.getRoot()).add(loadedProject);

        MapNodeComposite mapNode = (MapNodeComposite) ((MapTreeItem) treeModel.getRoot()).getMapNode();
        mapNode.addChild(project);

        for (MapNode map : project.getChildren()) {
            map.setParent(project);
            MapTreeItem mapTreeItem = new MapTreeItem(map);
            loadedProject.add(mapTreeItem);
        }
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }
}
