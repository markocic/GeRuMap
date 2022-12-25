package raf.dsw.gerumap.repository.factory;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Project;

public class ProjectFactory extends NodeFactory {
    @Override
    public MapNode createNode() {
        return new Project();
    }
}
