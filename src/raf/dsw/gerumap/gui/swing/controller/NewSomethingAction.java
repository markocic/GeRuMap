package raf.dsw.gerumap.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewSomethingAction extends AbstractGerumapAction{

    public NewSomethingAction() {
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
          //      KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/plus_icon.png"));
        putValue(SHORT_DESCRIPTION, "New addition");
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
