package raf.dsw.gerumap.gui.swing.grafika.model;

import java.awt.*;
import java.util.ArrayList;

public class PojamModel extends ElementModel {

    private String name;
    private Point coordinates;
    private Dimension size;
    private ArrayList<VezaModel> odlazeceVeze;
    private ArrayList<VezaModel> dolazeceVeze;

    public PojamModel(String name, Point coordinates, Dimension size, int stroke, Color color) {
        super(color, stroke);
        this.name = name;
        this.coordinates = coordinates;
        this.size = size;
        odlazeceVeze = new ArrayList<>();
        dolazeceVeze = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PojamModel)) return false;

        // 2 pojma su jednaka ukoliko imaju isto ime, velicinu i koordinate
        return this.getName().equals(((PojamModel) obj).getName()) &&
                this.getSize().equals(((PojamModel) obj).getSize()) &&
                this.getCoordinates().equals(((PojamModel) obj).getCoordinates());
    }

    public void addDolazecaVeza(VezaModel veza) {
        if (veza == null) return;
        dolazeceVeze.add(veza);
        notifyGrafikaSubscribers();
    }

    public void removeDolazecaVeza(VezaModel veza) {
        if (veza == null || dolazeceVeze.isEmpty()) return;
        dolazeceVeze.remove(veza);
        notifyGrafikaSubscribers();
    }

    public void addOdlazecaVeza(VezaModel veza) {
        if (veza == null) return;
        odlazeceVeze.add(veza);
        notifyGrafikaSubscribers();
    }

    public void removeOdlazecaVeza(VezaModel veza) {
        if (veza == null || dolazeceVeze.isEmpty()) return;
        odlazeceVeze.remove(veza);
        notifyGrafikaSubscribers();
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

    public ArrayList<VezaModel> getOdlazeceVeze() {
        return odlazeceVeze;
    }

    public void setOdlazeceVeze(ArrayList<VezaModel> odlazeceVeze) {
        this.odlazeceVeze = odlazeceVeze;
    }

    public ArrayList<VezaModel> getDolazeceVeze() {
        return dolazeceVeze;
    }

    public void setDolazeceVeze(ArrayList<VezaModel> dolazeceVeze) {
        this.dolazeceVeze = dolazeceVeze;
    }

}
