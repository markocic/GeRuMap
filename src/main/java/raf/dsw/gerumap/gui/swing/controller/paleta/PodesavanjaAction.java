package raf.dsw.gerumap.gui.swing.controller.paleta;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class PodesavanjaAction extends AbstractGerumapAction {

    public PodesavanjaAction() {
        putValue(SMALL_ICON, loadIcon("/images/settings.png"));
        putValue(NAME, "Podesavanja");
        putValue(SHORT_DESCRIPTION, "Podesavanja");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startPodesavanjaState();
        setActive(this);
    }
}
