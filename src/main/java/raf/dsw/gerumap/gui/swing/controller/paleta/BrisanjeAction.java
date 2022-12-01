package raf.dsw.gerumap.gui.swing.controller.paleta;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BrisanjeAction extends AbstractGerumapAction {

    public BrisanjeAction() {
        putValue(SMALL_ICON, loadIcon("/images/exit_icon.png"));
        putValue(NAME, "Brisanje");
        putValue(SHORT_DESCRIPTION, "Brisanje pojma ili veze");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
        System.out.println("TO DO Brisanje action");

=======
        MainFrame.getInstance().getRightPanel().startBrisanjeState();
        setActive(this);
>>>>>>> 1fc0c0f (dodat mediator state sablona, dodate akcije u paletu, napravljena mogucnost za vizuelni prikaz trenutnog aktivnog stejta)
    }
}
