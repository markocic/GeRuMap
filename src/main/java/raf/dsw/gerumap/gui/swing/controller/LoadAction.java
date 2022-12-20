package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoadAction extends AbstractGerumapAction{


    public LoadAction() {
        putValue(SMALL_ICON, loadIcon("/images/load.png"));
        putValue(NAME, "Load");
        putValue(SHORT_DESCRIPTION, "Load .grm file");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //pravi novi modal za file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(MainFrame.getInstance());

    }
}