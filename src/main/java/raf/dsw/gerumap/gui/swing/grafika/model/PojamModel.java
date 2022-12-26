package raf.dsw.gerumap.gui.swing.grafika.model;

import java.awt.*;
import java.util.ArrayList;

public class PojamModel extends ElementModel {

    private String name;
    private Point coordinates;
    private Dimension size;
    private ArrayList<VezaModel> odlazeceVeze;
    private ArrayList<VezaModel> dolazeceVeze;
    private boolean isCentralni = false;
    private int level = 0;
    private int strana = 1;

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
        if (dolazeceVeze.contains(veza)) return;
        dolazeceVeze.add(veza);
        notifyGrafikaSubscribers(null, null);
    }

    public void removeDolazecaVeza(VezaModel veza) {
        dolazeceVeze.remove(veza);
        notifyGrafikaSubscribers(null, null);
    }

    public void addOdlazecaVeza(VezaModel veza) {
        if (veza == null) return;
        if (odlazeceVeze.contains(veza)) return;
        odlazeceVeze.add(veza);
        notifyGrafikaSubscribers(null, null);
    }

    public void removeOdlazecaVeza(VezaModel veza) {
        odlazeceVeze.remove(veza);
        notifyGrafikaSubscribers(null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyGrafikaSubscribers(null, null);
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
        updateVeze(new Point(coordinates.x + size.width / 2, coordinates.y + size.height / 2));
        notifyShape(coordinates, size);
        notifyGrafikaSubscribers(null, null);
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
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

    public void updateVeze(Point point) {
        for (VezaModel veza : odlazeceVeze) {
            veza.setPocetnaTacka(point);
        }

        for (VezaModel veza : dolazeceVeze) {
            veza.setKrajnjaTacka(point);
        }
    }

    public boolean isCentralni() {
        return isCentralni;
    }

    public void setCentralni(boolean centralni) {
        isCentralni = centralni;
    }

    @Override
    public void notifyShape(Object point, Object size) {

    }

    @Override
    public String toString() {
        return name + " " + level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrana() {
        return strana;
    }

    public void setStrana(int strana) {
        this.strana = strana;
    }
}
