package raf.dsw.gerumap.gui.swing.grafika;

import raf.dsw.gerumap.gui.swing.grafika.model.PojamView;
import raf.dsw.gerumap.repository.implementation.Element;

import javax.swing.*;
import java.awt.*;
import java.beans.VetoableChangeListener;
import java.util.Iterator;

public class RadnaPovrsina extends JPanel {
    public RadnaPovrsina() {
        this.setBackground(Color.BLACK);
    }

    public void PaintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D g2  = (Graphics2D) graphics;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.8f));





    }
}
