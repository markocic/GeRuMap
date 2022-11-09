package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

public class Element extends MapNode {
    public Element(String name, MapNode parent) {
        super(name, parent);
    }

    public Element() {
        super("no name element", null);

    }
}
