package raf.dsw.gerumap.gui.swing.controller.paleta;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class CentralniAction extends AbstractGerumapAction {
    public CentralniAction() {
        putValue(SMALL_ICON, loadIcon("/images/centralni.png"));
        putValue(NAME, "Centralni pojam");
        putValue(SHORT_DESCRIPTION, "Centralni pojam");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startCentralniState();
        setActive(this);
    }
}
