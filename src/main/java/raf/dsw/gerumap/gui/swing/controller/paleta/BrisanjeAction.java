package raf.dsw.gerumap.gui.swing.controller.paleta;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class BrisanjeAction extends AbstractGerumapAction {

    public BrisanjeAction() {
        putValue(SMALL_ICON, loadIcon("/images/deleteStuff.png"));
        putValue(NAME, "Brisanje");
        putValue(SHORT_DESCRIPTION, "Brisanje pojma ili veze");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startBrisanjeState();
        setActive(this);
    }
}
