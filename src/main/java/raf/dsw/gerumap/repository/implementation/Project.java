package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

public class Project extends MapNodeComposite {
    private String author;
    private String path;
    private static int counter = 0;

    public Project() {
        super("Project " + counter, null);
        counter++;
    }
    public Project(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null && child instanceof MindMap) {
            MindMap mindMap = (MindMap) child;
            if (!this.getChildren().contains(mindMap)) {
                this.getChildren().add(mindMap);
            }
        }
        this.notifySubscribers(this);
    }

    @Override
    public void deleteChild(MapNode child) {
        if (child != null && child instanceof MindMap) {
            MindMap mindMap = (MindMap) child;
            if (this.getChildren().contains(mindMap)) {
                this.getChildren().remove(mindMap);
            }
        }
        this.notifySubscribers(this);
    }

    public Project(String name, MapNode parent, String author, String path) {
        super(name, parent);
        this.author = author;
        this.path = path;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        this.notifySubscribers(this);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Project.counter = counter;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
