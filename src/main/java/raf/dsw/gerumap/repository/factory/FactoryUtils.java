package raf.dsw.gerumap.repository.factory;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

public class FactoryUtils {
    private ProjectFactory projectFactory = new ProjectFactory();
    private MapFactory mapFactory = new MapFactory();
    private ElementFactory elementFactory = new ElementFactory();

    public NodeFactory getFactory(MapNode parent) {
        if (parent instanceof ProjectExplorer) return this.projectFactory;
        else if (parent instanceof Project) return this.mapFactory;
        else if (parent instanceof MindMap) return this.elementFactory;
        else return null;
    }
}
