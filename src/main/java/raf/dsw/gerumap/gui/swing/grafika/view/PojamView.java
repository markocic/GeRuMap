package raf.dsw.gerumap.gui.swing.grafika.view;

import java.awt.*;

public class PojamView extends ElementView{

    private String name;
    private Point coordinates;
    private Dimension size;

    public PojamView(String name, Point coordinates, Dimension size, int stroke, Color color) {
        super(color, stroke);
        this.name = name;
        this.coordinates = coordinates;
        this.size = size;
    }

}
