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
    // int currentCommand, int komandeSize
    public void refreshUndoRedoButtons() {
        int currentCommand = MainFrame.getInstance().getRightPanel().getCurrentMapView().getMapa().getCommandManager().getCurrentCommand();
        int komandeSize = MainFrame.getInstance().getRightPanel().getCurrentMapView().getMapa().getCommandManager().getKomande().size();

        if(currentCommand == 0){
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
        } else if(currentCommand < komandeSize){
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
        } if(currentCommand == komandeSize){
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
        } if (currentCommand == 0 && currentCommand == komandeSize) {
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
        }
    }
}
