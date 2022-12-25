package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.logger.TipPoruke;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class OpenProjectAction extends AbstractGerumapAction {

    public OpenProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/openFolder.png"));
        putValue(NAME, "Open Project");
        putValue(SHORT_DESCRIPTION, "Open Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getMapTree().getSelectedNode() == null) {
            AppCore.getInstance().getMsgGenerator().generateMsg("Morate selektovati projekat koji zelite da otvorite", TipPoruke.OBAVJESTENJE);
            return;
        }

        ((MapTree) MainFrame.getInstance().getMapTree()).openSelectedNode();
    }
}
