package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
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

    ///jos dosta toga


    public boolean isTemplate() {
        return template;
    }

    public void setTemplate(boolean template) {
        this.template = template;
    }
}
