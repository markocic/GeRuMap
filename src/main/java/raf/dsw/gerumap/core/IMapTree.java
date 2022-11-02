package raf.dsw.gerumap.core;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

public interface IMapTree {
    IMapTree generateTree(ProjectExplorer projectExplorer);
    void addChild(MapTreeItem parent);
    MapTreeItem getSelectedNode();
}
