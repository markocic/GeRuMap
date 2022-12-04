package raf.dsw.gerumap.gui.swing.grafika.model;

import java.awt.*;

public class PojamView extends ElementView{

    private String name;
    private int size;
    private int position;

    public PojamView(int stroke, Color color, String name, int size, int position) {
        super(stroke, color);
        this.name = name;
        this.size = size;
        this.position = position;
    }

}
