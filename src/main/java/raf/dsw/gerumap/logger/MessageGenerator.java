package raf.dsw.gerumap.logger;

import raf.dsw.gerumap.gui.swing.observer.ISubscriber;
import raf.dsw.gerumap.gui.swing.observer.MsgPublisher;
import raf.dsw.gerumap.gui.swing.observer.MsgSubscriber;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class MessageGenerator implements MsgPublisher {

    private String message;
    private TipPoruke tipPoruke;
    private Time timeStamp;

    private List<MsgSubscriber> msgSubscriberList;
    public MessageGenerator() {
    }


    public void generateMsg(String tekst){



    }


    @Override
    public void addSubscriber(MsgSubscriber sub) {
        if (sub == null) return;
        if (msgSubscriberList == null) msgSubscriberList = new ArrayList<>();
        if (this.msgSubscriberList.contains(sub)) return;

        msgSubscriberList.add(sub);
    }

    @Override
    public void removeSubscriber(MsgSubscriber sub) {
        if (sub == null) return;
        if (msgSubscriberList == null) msgSubscriberList = new ArrayList<>();
        if (msgSubscriberList.contains(sub)) {
            msgSubscriberList.remove(sub);
        }
        if(sub == null || this.msgSubscriberList == null || !this.msgSubscriberList.contains(sub)) return;
        this.msgSubscriberList.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if (notification == null || this.msgSubscriberList == null || this.msgSubscriberList.isEmpty()) return;
        for (MsgSubscriber sub: this.msgSubscriberList) {
            sub.update(notification);
        }
    }
}
