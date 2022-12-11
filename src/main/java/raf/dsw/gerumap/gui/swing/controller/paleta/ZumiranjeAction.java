package raf.dsw.gerumap.gui.swing.controller.paleta;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;

import java.awt.event.ActionEvent;

public class ZumiranjeAction extends AbstractGerumapAction {
    public ZumiranjeAction() {
        putValue(SMALL_ICON, loadIcon("/images/lupa.png"));
        putValue(NAME, "Zumiranje");
        putValue(SHORT_DESCRIPTION, "Zumiranje");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getRightPanel().startZumiranjeState();
        setActive(this);

    }
}
