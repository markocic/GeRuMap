package raf.dsw.gerumap.gui.swing.controller;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractGerumapAction{
    public UndoAction() {
        putValue(SMALL_ICON, loadIcon("/images/undo.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo your recent action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //na panelu vraca desavanje nazad
    }
}
