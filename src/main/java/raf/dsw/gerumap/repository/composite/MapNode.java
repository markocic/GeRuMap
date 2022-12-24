package raf.dsw.gerumap.repository.composite;

import raf.dsw.gerumap.gui.swing.observer.IPublisher;
import raf.dsw.gerumap.gui.swing.observer.ISubscriber;
import raf.dsw.gerumap.repository.implementation.MindMap;

import java.util.ArrayList;
import java.util.List;

public abstract class MapNode implements IPublisher {

    private String name;
    private transient MapNode parent;

    private transient List<ISubscriber> subscribers;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MapNode)
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

    @Override
    public void notifyAuthorChanged(String newAuthor) {
        if (newAuthor == null || this.subscribers == null || this.subscribers.isEmpty()) return;
        for (ISubscriber sub : this.subscribers) {
            sub.updateAuthorName(newAuthor);
        }
    }

    @Override
    public void notifyProjectNameChanged(String newProjectName) {
        if (newProjectName == null || this.subscribers == null || this.subscribers.isEmpty()) return;
        for (ISubscriber sub : this.subscribers) {
            sub.updateProjectNameChanged(newProjectName);
        }
    }

    @Override
    public void notifyMindMapCreated(MindMap mindMap) {
        if (mindMap == null || this.subscribers == null || this.subscribers.isEmpty()) return;
        for (ISubscriber sub : this.subscribers) {
            sub.updateMindMapCreated(mindMap);
        }
    }

    @Override
    public void notifyMindMapDeleted(String name) {
        if (name == null || this.subscribers == null || this.subscribers.isEmpty()) return;
        for (ISubscriber sub : this.subscribers) {
            sub.updateMindMapDeleted(name);
        }
    }


    @Override
    public void notifyProjectOpened(Object project) {
        if (project == null || this.subscribers == null || this.subscribers.isEmpty()) return;
        for (ISubscriber sub : this.subscribers) {
            sub.updateProjectOpened(project);
        }
    }

    @Override
    public void notifyMindMapNameChanged(String oldName, String newName) {
        if (oldName == null || newName == null || this.subscribers == null || this.subscribers.isEmpty()) return;
        for (ISubscriber sub : this.subscribers) {
            sub.updateMindMapNameChanged(oldName, newName);

        }
    }

    @Override
    public void notifyOpenedProjectDeleted() {
        if (this.subscribers == null || this.subscribers.isEmpty()) return;
        for (ISubscriber sub : this.subscribers) {
            sub.updateOpenedProjectDeleted();

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
