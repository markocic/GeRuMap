package raf.dsw.gerumap.gui.swing.observer;

public interface GrafikaPublisher {

    void addGrafikaSubscriber(GrafikaSubscriber sub);
    void removeGrafikaSubscriber(GrafikaSubscriber sub);
    void notifyGrafikaSubscribers();

}
