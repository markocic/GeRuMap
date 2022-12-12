package raf.dsw.gerumap.gui.swing.observer;

import java.awt.*;

public interface GrafikaSubscriber {
    void update();
    void updateShape(Point pocetnaTacka, Point krajnjaTacka);
}
