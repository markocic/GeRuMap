package raf.dsw.gerumap.gui.swing.observer;

import raf.dsw.gerumap.repository.command.CommandType;

import java.awt.*;

public interface GrafikaPublisher {

    void addGrafikaSubscriber(GrafikaSubscriber sub);
    void removeGrafikaSubscriber(GrafikaSubscriber sub);
    void notifyGrafikaSubscribers(CommandType commandType, Object obj);

    void notifyShape(Point pocetnaTacka, Point krajnjaTacka);

}
