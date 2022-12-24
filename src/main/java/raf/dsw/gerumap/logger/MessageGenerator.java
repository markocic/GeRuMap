package raf.dsw.gerumap.logger;

import raf.dsw.gerumap.gui.swing.observer.MsgPublisher;
import raf.dsw.gerumap.gui.swing.observer.MsgSubscriber;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MessageGenerator implements MsgPublisher {

    private String message;
    private TipPoruke tipPoruke;
    private LocalDateTime time;

    private List<MsgSubscriber> msgSubscriberList;
    public MessageGenerator() {
    }


    public void generateMsg(String message, TipPoruke tipPoruke){
        this.message = message;
        this.tipPoruke = tipPoruke;
        this.time = java.time.LocalDateTime.now();

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
        msgSubscriberList.remove(sub);
        if(this.msgSubscriberList == null || !this.msgSubscriberList.contains(sub)) return;
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
        return "[" + this.tipPoruke + "] [" + dtf.format(time) + "] " + this.message;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<MsgSubscriber> getMsgSubscriberList() {
        return msgSubscriberList;
    }

    public void setMsgSubscriberList(List<MsgSubscriber> msgSubscriberList) {
        this.msgSubscriberList = msgSubscriberList;
    }

}
