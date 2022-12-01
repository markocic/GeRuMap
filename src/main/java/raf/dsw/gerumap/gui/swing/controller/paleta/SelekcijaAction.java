package raf.dsw.gerumap.gui.swing.controller.paleta;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class SelekcijaAction extends AbstractGerumapAction {
    public SelekcijaAction() {
        putValue(SMALL_ICON, loadIcon("/images/select.png"));
        putValue(NAME, "Selekcija");
        putValue(SHORT_DESCRIPTION, "Selekcija");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startSelekcijaState();
        setActive(this);

    }
}
