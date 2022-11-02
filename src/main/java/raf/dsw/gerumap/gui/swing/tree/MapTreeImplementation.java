package raf.dsw.gerumap.gui.swing.tree;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MapTreeImplementation implements  MapTree{

    private MapTreeView treeView;
    private DefaultTreeModel treeModel;




    @Override
    public MapTree generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(treeModel);
        //return treeView;
        return null; // trenutno nije napravljeno da valja
    }

    @Override
    public void addChild(MapTreeItem parent) {
        if(!((parent.getMapNode()) instanceof MapNodeComposite))return;

        MapNode child = createChild(parent.getMapNode());
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);

    }

    @Override
    public MapTreeItem getSelectedNode() {
        return null;
    }

    private MapNode createChild(MapNode parent){
        if(parent instanceof ProjectExplorer){
            return new Project("Project" + "bilo koji broj",parent);
        }
        return null;
    }


}