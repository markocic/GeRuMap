package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.logger.TipPoruke;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractGerumapAction{

    public DeleteAction() {
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_DELETE);
        putValue(SMALL_ICON, loadIcon("/images/deleteStuff.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getMapTree().getSelectedNode() == null) {
            AppCore.getInstance().getMsgGenerator().generateMsg("Niste selektovali sta zelite da obrisete", TipPoruke.OBAVJESTENJE);
            return;
        }
        if (MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof ProjectExplorer)  {
            AppCore.getInstance().getMsgGenerator().generateMsg("Ne mozete obrisati Project Explorer", TipPoruke.GRESKA);
            return;
        }
        MainFrame.getInstance().getMapTree().deleteChild(MainFrame.getInstance().getMapTree().getSelectedNode());
    }
}
