package raf.dsw.gerumap.logger;

import raf.dsw.gerumap.gui.swing.observer.ISubscriber;
import raf.dsw.gerumap.gui.swing.observer.MsgPublisher;
import raf.dsw.gerumap.gui.swing.observer.MsgSubscriber;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MessageGenerator implements MsgPublisher {

    private String message;
    private TipPoruke tipPoruke;
    private LocalTime time;

    private List<MsgSubscriber> msgSubscriberList;
    public MessageGenerator() {
    }


    public void generateMsg(String message, TipPoruke tipPoruke){
        this.message = message;
        this.tipPoruke = tipPoruke;
        this.time = java.time.LocalTime.now();

        this.notifySubscribers();

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
    public void notifySubscribers() {
        if (this.msgSubscriberList == null || this.msgSubscriberList.isEmpty()) return;
        for (MsgSubscriber sub: this.msgSubscriberList) {
            sub.update(this);
        }
    }

    @Override
    public String toString() {
        return "[" + this.tipPoruke + "] [" + this.time.toString() + "] " + this.message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TipPoruke getTipPoruke() {
        return tipPoruke;
    }

    public void setTipPoruke(TipPoruke tipPoruke) {
        this.tipPoruke = tipPoruke;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public List<MsgSubscriber> getMsgSubscriberList() {
        return msgSubscriberList;
    }

    public void setMsgSubscriberList(List<MsgSubscriber> msgSubscriberList) {
        this.msgSubscriberList = msgSubscriberList;
    }

    public void setTimeStamp(LocalTime time) {
        this.time = time;
    }
}
