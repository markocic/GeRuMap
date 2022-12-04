package raf.dsw.gerumap.gui.swing.grafika.painters;



import raf.dsw.gerumap.gui.swing.grafika.model.ElementView;

import java.awt.*;

public abstract class ElementPainter {
    ElementView element;
    Shape shape;
    public void draw(Graphics2D graphics2D) {};
    public boolean elementAt(int x,int y){
        return false;
    };



}
