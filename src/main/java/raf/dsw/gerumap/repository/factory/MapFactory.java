package raf.dsw.gerumap.repository.factory;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;

public class MapFactory extends NodeFactory {

    @Override
    public MapNode createNode() {
        MindMap child = new MindMap();
        return child;
    }
}
