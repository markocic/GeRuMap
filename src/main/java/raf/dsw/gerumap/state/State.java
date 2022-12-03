package raf.dsw.gerumap.state;

import raf.dsw.gerumap.repository.implementation.MindMap;

public abstract class State {
    public void performAction(int x, int y, MindMap map) {
        System.out.println("placeholder, need to be overridden");
    }
}
