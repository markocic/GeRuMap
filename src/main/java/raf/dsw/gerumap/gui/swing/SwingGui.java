package raf.dsw.gerumap.gui.swing;

import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.logger.MessageGenerator;
import raf.dsw.gerumap.logger.TipPoruke;

import javax.swing.*;

public class SwingGui implements Gui {

    public SwingGui() {

    }

    @Override
    public void start() {
        MainFrame.getInstance().setVisible(true);
    }

    @Override
    public void update(Object notification) {
        // izbaci error poruku
        MessageGenerator msg = (MessageGenerator) notification;
        JOptionPane poruka;
        if (msg.getTipPoruke() == TipPoruke.GRESKA) {
            poruka = new JOptionPane(msg.getMessage(), JOptionPane.ERROR_MESSAGE);

        }
        else if (msg.getTipPoruke() == TipPoruke.UPOZORENJE) {
            poruka = new JOptionPane(msg.getMessage(), JOptionPane.WARNING_MESSAGE);
        }
        else if (msg.getTipPoruke() == TipPoruke.OBAVJESTENJE) {
            poruka = new JOptionPane(msg.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        } else {
            poruka = new JOptionPane(msg.getMessage());
        }

        poruka.setVisible(true);
    }
}
