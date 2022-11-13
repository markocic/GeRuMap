package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class OpenProjectAction extends AbstractGerumapAction {

    public OpenProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
//        putValue(SMALL_ICON, loadIcon("/images/plus_icon.png"));
        putValue(NAME, "Open Project");
        putValue(SHORT_DESCRIPTION, "Open Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((MapTree) MainFrame.getInstance().getMapTree()).openSelectedNode();
    }
}
