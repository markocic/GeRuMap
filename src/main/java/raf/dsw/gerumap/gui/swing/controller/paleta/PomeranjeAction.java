package raf.dsw.gerumap.gui.swing.controller.paleta;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;

import java.awt.event.ActionEvent;

public class PomeranjeAction extends AbstractGerumapAction {
    public PomeranjeAction() {
        putValue(SMALL_ICON, loadIcon("/images/move.png"));
        putValue(NAME, "Pomeranje");
        putValue(SHORT_DESCRIPTION, "pomeranje");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
