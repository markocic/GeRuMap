package raf.dsw.gerumap.core;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

public interface IMapRepository {
    ProjectExplorer getProjectExplorer();
    void addChild(MapNodeComposite parent, MapNode child);
}
