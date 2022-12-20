package raf.dsw.gerumap.gui.swing.controller;

import javax.swing.*;
import javax.swing.filechooser.FileView;
import java.awt.event.ActionEvent;

public class SaveAction extends AbstractGerumapAction{

    public SaveAction() {
        putValue(SMALL_ICON, loadIcon("/images/save.png"));
        putValue(NAME, "Save");
        putValue(SHORT_DESCRIPTION, "Save your work");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //otvara modal sa filechooserom
    }
}
