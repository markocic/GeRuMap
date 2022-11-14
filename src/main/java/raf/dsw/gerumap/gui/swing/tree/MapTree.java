package raf.dsw.gerumap.gui.swing.tree;

import raf.dsw.gerumap.core.IMapTree;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;
import raf.dsw.gerumap.repository.factory.FactoryUtils;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.List;
import java.util.Random;

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
    public void addChild(MapTreeItem parent) {
        if(!((parent.getMapNode()) instanceof MapNodeComposite))return;

        MapNode child = createChild(parent.getMapNode());
        if (child.getParent() instanceof Project && openedNode != null &&child.getParent() == openedNode.getMapNode()) {
            child.addSubscriber(MainFrame.getInstance().getRightPanel());
        }
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);

    }

    @Override
    public void deleteChild(MapTreeItem child) {
        // TODO: funkcija koja ce obrisati child iz parent's child array
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

//        child.getMapNode().notifySubscribers(child.getMapNode());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    public void openSelectedNode() {
        if (!(this.openedNode == null)) {
            this.openedNode.getMapNode().removeSubscriber(MainFrame.getInstance().getRightPanel());
        }
        this.openedNode = this.getSelectedNode();
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
        MapNode child = new FactoryUtils().getFactory(parent).getNode(parent);
        return child;
    }


}
