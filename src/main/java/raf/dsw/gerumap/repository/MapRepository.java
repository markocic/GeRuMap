package raf.dsw.gerumap.repository;

import raf.dsw.gerumap.core.IMapRepository;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

public class MapRepository implements IMapRepository {
    private ProjectExplorer projectExplorer;

    public MapRepository() {
        projectExplorer = new ProjectExplorer("Project Explorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    @Override
    public void addChild(MapNodeComposite parent, MapNode child) {
        parent.addChild(child);
    }
}
