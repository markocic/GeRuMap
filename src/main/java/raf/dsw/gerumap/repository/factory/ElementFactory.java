package raf.dsw.gerumap.repository.factory;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Element;

public class ElementFactory extends NodeFactory {
    @Override
    public MapNode createNode() {
        return new Element();
    }
}
