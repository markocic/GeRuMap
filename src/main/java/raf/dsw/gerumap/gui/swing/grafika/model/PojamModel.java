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

}
