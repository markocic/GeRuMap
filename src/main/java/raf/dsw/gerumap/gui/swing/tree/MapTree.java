package raf.dsw.gerumap.gui.swing.tree;

import raf.dsw.gerumap.core.IMapTree;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;
import raf.dsw.gerumap.repository.factory.FactoryUtils;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.Random;

public class MapTree implements IMapTree {

    private MapTreeView treeView;
    private DefaultTreeModel treeModel;

    private MapTreeItem selectedNode;


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
        child.addSubscriber(MainFrame.getInstance().getRightPanel());
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

            Project parent = (Project) child.getMapNode().getParent();
            parent.deleteChild(child.getMapNode());
        }

        child.removeFromParent();

        child.getMapNode().notifySubscribers(child.getMapNode());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(MapTreeItem selectedNode) {
        this.selectedNode = selectedNode;
        selectedNode.getMapNode().notifySubscribers(selectedNode.getMapNode());
    }



    public MapNode createChild(MapNode parent){
        MapNode child = new FactoryUtils().getFactory(parent).getNode(parent);
        return child;
    }


}
