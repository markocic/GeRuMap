package raf.dsw.gerumap.gui.swing.grafika.model;

import java.awt.*;

public class PojamModel extends ElementModel {

    private String name;
    private Point coordinates;
    private Dimension size;

    public PojamModel(String name, Point coordinates, Dimension size, int stroke, Color color) {
        super(color, stroke);
        this.name = name;
        this.coordinates = coordinates;
        this.size = size;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PojamModel)) return false;

        // 2 pojma su jednaka ukoliko imaju isto ime, velicinu i koordinate
        return this.getName().equals(((PojamModel) obj).getName()) &&
                this.getSize().equals(((PojamModel) obj).getSize()) &&
                this.getCoordinates().equals(((PojamModel) obj).getCoordinates());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyGrafikaSubscribers();
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
        notifyGrafikaSubscribers();
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
//        notifyGrafikaSubscribers(); moramo da uklonimo jer stvara beskonacnu petlju update poziva
    }

    @Override
    public String toString() {
        return name;
    }
}
