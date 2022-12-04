package raf.dsw.gerumap.gui.swing.grafika.model;

import java.awt.*;

public class PojamView extends ElementView{

    private String name;
    private int height;
    private int width;
    private int x;
    private int y;

    public PojamView(int stroke, Color color, String name, int height, int width, int x, int y) {
        super(stroke, color);
        this.name = name;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

}
