package raf.dsw.gerumap.gui.swing.controller.paleta;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class DodajPojamAction extends AbstractGerumapAction {
    public DodajPojamAction() {
        putValue(SMALL_ICON, loadIcon("/images/plus_icon.png"));
        putValue(NAME, "Dodaj pojam");
        putValue(SHORT_DESCRIPTION, "Dodaj pojam");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startDodajPojamState();
        setActive(this);
    }
}
