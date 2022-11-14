package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

public class MindMap extends MapNodeComposite {
    private boolean template;
    private static int counter = 0;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null && child instanceof Element) {
            Element element = (Element) child;
            if (!this.getChildren().contains(element)) {
                this.getChildren().add(element);
            }
        }

        this.notifySubscribers(this);
    }

    @Override
    public void deleteChild(MapNode child) {
        if (child != null && child instanceof Element) {
            Element element = (Element) child;
            if (this.getChildren().contains(element)) {
                this.getChildren().remove(element);
            }
        }

        this.notifySubscribers(this);
    }

    public MindMap() {
        super("Map " + counter, null);
        counter++;
    }


    @Override
    public void setName(String name) {
        this.notifyMindMapNameChanged(this.getName(), name);
        super.setName(name);
    }

    public boolean isTemplate() {
        return template;
    }

    public void setTemplate(boolean template) {
        this.template = template;
    }
}
