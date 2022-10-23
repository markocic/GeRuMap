package raf.dsw.gerumap.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewProjectAction extends AbstractGerumapAction {
    public NewProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/plus_icon.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }

    public void actionPerformed(ActionEvent arg0) {

    }

}
