package raf.dsw.gerumap.gui.swing;

import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.gui.swing.command.CommandManager;
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
    public void disabelUndoAction() {

    }

    @Override
    public void disableRedoAction() {

    }

    @Override
    public void enableUndoAction() {

    }

    @Override
    public void enableRedoAction() {

    }

    @Override
    public CommandManager getCommandManager() {
        return null;
    }

    @Override
    public void update(Object notification) {
        // izbaci error poruku
        MessageGenerator msg = (MessageGenerator) notification;
        if (msg.getTipPoruke() == TipPoruke.GRESKA) {
            JOptionPane.showMessageDialog(MainFrame.getInstance(), msg.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
        else if (msg.getTipPoruke() == TipPoruke.UPOZORENJE) {
            JOptionPane.showMessageDialog(MainFrame.getInstance(), msg.getMessage(), "Upozorenje", JOptionPane.WARNING_MESSAGE);

        }
        else if (msg.getTipPoruke() == TipPoruke.OBAVJESTENJE) {
            JOptionPane.showMessageDialog(MainFrame.getInstance(), msg.getMessage(), "Obavestenje", JOptionPane.INFORMATION_MESSAGE);

        }
    }
}
