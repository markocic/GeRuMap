package raf.dsw.gerumap.gui.swing.observer;

import java.awt.*;

public interface GrafikaPublisher {

    void addGrafikaSubscriber(GrafikaSubscriber sub);
    void removeGrafikaSubscriber(GrafikaSubscriber sub);
    void notifyGrafikaSubscribers();

    void notifyShape(Point pocetnaTacka, Point krajnjaTacka);

}
