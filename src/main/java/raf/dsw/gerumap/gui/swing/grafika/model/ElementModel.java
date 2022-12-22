package raf.dsw.gerumap.gui.swing.grafika.model;

import raf.dsw.gerumap.gui.swing.observer.GrafikaPublisher;
import raf.dsw.gerumap.gui.swing.observer.GrafikaSubscriber;
import raf.dsw.gerumap.repository.command.CommandType;

import java.awt.*;
import java.util.ArrayList;

// publisher
public abstract class ElementModel implements GrafikaPublisher {
    private ArrayList<GrafikaSubscriber> subscribers = new ArrayList<>();
    private Color color;
    private int stroke;

    public ElementModel(Color color, int stroke) {
        this.color = color;
        this.stroke = stroke;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        notifyGrafikaSubscribers(null, null);
    }

    public int getStroke() {
        return stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
        notifyGrafikaSubscribers(null, null);
    }

    @Override
    public void addGrafikaSubscriber(GrafikaSubscriber sub) {
        if (sub == null) return;
        if (this.subscribers == null) this.subscribers = new ArrayList<>();
        if (this.subscribers.contains(sub)) return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeGrafikaSubscriber(GrafikaSubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub)) return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifyGrafikaSubscribers(CommandType commandType, Object obj) {
        if (this.subscribers == null || this.subscribers.isEmpty()) return;
        for (GrafikaSubscriber sub : this.subscribers) {
            sub.update(commandType, obj);
        }
    }

    public ArrayList<GrafikaSubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(ArrayList<GrafikaSubscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
