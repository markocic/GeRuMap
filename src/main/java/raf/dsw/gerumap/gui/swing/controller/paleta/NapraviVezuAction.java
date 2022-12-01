package raf.dsw.gerumap.gui.swing.controller.paleta;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class NapraviVezuAction extends AbstractGerumapAction {

    public NapraviVezuAction() {
        putValue(SMALL_ICON, loadIcon("/images/add_link.png"));
        putValue(NAME, "Napravi vezu");
        putValue(SHORT_DESCRIPTION, "Napravi vezu");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startNapraviVezuState();
        setActive(this);

    }
}
