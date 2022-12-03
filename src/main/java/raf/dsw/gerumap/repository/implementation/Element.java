package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;

public class Element extends MapNode {

    private static int counter = 0;
    public Element(String name, MapNode parent) {
        super(name, parent);
    }

    public Element() {
        super("Element " + counter, null);
        counter++;
    }
}
