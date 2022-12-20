package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.observer.GrafikaPublisher;
import raf.dsw.gerumap.gui.swing.observer.GrafikaSubscriber;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

import java.awt.*;
import java.util.ArrayList;

public class MindMap extends MapNodeComposite implements GrafikaPublisher {

    private transient ArrayList<GrafikaSubscriber> grafikaSubscribers = new ArrayList<>();
    private ArrayList<ElementModel> models = new ArrayList<>();
    private boolean template;
    private static int counter = 0;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child instanceof Element element) {
            if (!this.getChildren().contains(element)) {
                this.getChildren().add(element);
            }
        }

        this.notifySubscribers(this);
    }

    @Override
    public void deleteChild(MapNode child) {
        if (child instanceof Element element) {
            this.getChildren().remove(element);
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

    @Override
    public void addGrafikaSubscriber(GrafikaSubscriber sub) {
        if (sub == null) return;
        if (this.grafikaSubscribers == null) this.grafikaSubscribers = new ArrayList<>();
        if (this.grafikaSubscribers.contains(sub)) return;
        this.grafikaSubscribers.add(sub);
    }

    @Override
    public void removeGrafikaSubscriber(GrafikaSubscriber sub) {
        if(sub == null || this.grafikaSubscribers == null || !this.grafikaSubscribers.contains(sub)) return;
        this.grafikaSubscribers.remove(sub);
    }

    @Override
    public void notifyGrafikaSubscribers() {
        if (this.grafikaSubscribers == null || this.grafikaSubscribers.isEmpty()) return;
        for (GrafikaSubscriber sub : this.grafikaSubscribers) {
            sub.update();
        }
    }

    @Override
    public void notifyShape(Point pocetnaTacka, Point krajnjaTacka) {}

    public void addModel(ElementModel model) {
        if (model == null) return;
        models.add(model);
        notifyGrafikaSubscribers();
    }

    public void addModelAtIndex(ElementModel model, int index) {
        if (model == null) return;
        models.add(index, model);
        notifyGrafikaSubscribers();
    }

    public void removeModel(ElementModel model) {
        if (model == null) return;
        models.remove(model);
        notifyGrafikaSubscribers();
    }

    public ArrayList<ElementModel> getModels() {
        return models;
    }

    public void setModels(ArrayList<ElementModel> models) {
        this.models = models;
    }
}
