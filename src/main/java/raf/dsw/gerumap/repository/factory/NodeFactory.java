package raf.dsw.gerumap.repository.factory;

import raf.dsw.gerumap.repository.composite.MapNode;

public abstract class NodeFactory {

    protected abstract MapNode createNode();

    public MapNode getNode(MapNode parent) {
        MapNode node = createNode();
        node.setParent(parent);
        return node;
    }
}
