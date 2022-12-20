package raf.dsw.gerumap.gui.swing.controller;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractGerumapAction{

    public RedoAction() {
        putValue(SMALL_ICON, loadIcon("/images/redo.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo an action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //omogucava vadjenje i brisanje iz "stack ili liste dogadjaja" desavanja
    }
}
