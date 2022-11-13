package raf.dsw.gerumap.repository.composite;

import raf.dsw.gerumap.core.IPublisher;
import raf.dsw.gerumap.core.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public abstract class MapNode implements IPublisher {

    private String name;
    private MapNode parent;

    private List<ISubscriber> subscribers;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof MapNode)
        {
            MapNode node = (MapNode) obj;
            return this.getName().equals(node.getName());
        }
        return false;
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if (sub == null) return;
        if (this.subscribers == null) this.subscribers = new ArrayList<>();
        if (this.subscribers.contains(sub)) return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub)) return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if (notification == null || this.subscribers == null || this.subscribers.isEmpty()) return;
        for (ISubscriber sub : this.subscribers) {
            sub.update(notification);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapNode getParent() {
        return parent;
    }

    public void setParent(MapNode parent) {
        this.parent = parent;
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
