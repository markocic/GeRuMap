package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;

public class Project extends MapNode {
    private String author;
    private String path;
    public Project(String name, MapNode parent) {
        super(name, parent);
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
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
