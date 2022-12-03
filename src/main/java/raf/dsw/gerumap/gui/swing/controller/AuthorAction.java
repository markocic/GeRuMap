package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.AuthorModal;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.logger.TipPoruke;
import raf.dsw.gerumap.repository.implementation.Project;

import java.awt.event.ActionEvent;

public class AuthorAction extends AbstractGerumapAction {

    public AuthorAction() {
        putValue(SMALL_ICON, loadIcon("/images/user.png"));
        putValue(NAME, "Author");
        putValue(SHORT_DESCRIPTION, "Author");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getMapTree().getSelectedNode() == null) {
            AppCore.getInstance().getMsgGenerator().generateMsg("Niste selektovali nijedan projekat", TipPoruke.OBAVJESTENJE);
            return;
        }
        if (!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)) {
            AppCore.getInstance().getMsgGenerator().generateMsg("Autora mozete menjati samo za projekat", TipPoruke.GRESKA);
            return;
        }
        AuthorModal authorModal = new AuthorModal(MainFrame.getInstance());

    }
}
