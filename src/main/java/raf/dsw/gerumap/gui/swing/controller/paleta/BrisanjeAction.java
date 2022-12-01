package raf.dsw.gerumap.gui.swing.controller.paleta;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;

import java.awt.event.ActionEvent;

public class BrisanjeAction extends AbstractGerumapAction {

    public BrisanjeAction() {
        putValue(SMALL_ICON, loadIcon("/images/exit_icon.png"));
        putValue(NAME, "Brisanje");
        putValue(SHORT_DESCRIPTION, "Brisanje pojma ili veze");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("TO DO Brisanje action");

    }
}
