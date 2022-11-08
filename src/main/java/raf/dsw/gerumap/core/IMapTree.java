package raf.dsw.gerumap.core;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

public interface IMapTree {
    MapTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(MapTreeItem parent);

    void deleteChild(MapTreeItem child);

    MapTreeItem getSelectedNode();
}
