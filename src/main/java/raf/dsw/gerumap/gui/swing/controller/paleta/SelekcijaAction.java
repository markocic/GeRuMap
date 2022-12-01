package raf.dsw.gerumap.gui.swing.controller.paleta;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;

import java.awt.event.ActionEvent;

public class SelekcijaAction extends AbstractGerumapAction {
    public SelekcijaAction() {
        putValue(SMALL_ICON, loadIcon("/images/select.png"));
        putValue(NAME, "Selekcija");
        putValue(SHORT_DESCRIPTION, "Selekcija");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
