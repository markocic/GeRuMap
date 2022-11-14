package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class MapView extends JPanel {
    private JLabel labelIme;


    public MapView(String name) {
        labelIme = new JLabel();
        this.add(labelIme);
        this.setBackground(Color.lightGray); // trenutno postavljeno radi razlikovanja

    }

    public JLabel getLabelIme() {
        return labelIme;
    }

    public void setLabelIme(JLabel labelIme) {
        this.labelIme = labelIme;
    }
}
