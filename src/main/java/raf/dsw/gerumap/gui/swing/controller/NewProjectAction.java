package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.logger.TipPoruke;
import raf.dsw.gerumap.repository.implementation.Element;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewProjectAction extends AbstractGerumapAction {
    public NewProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus_icon.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }

    public void actionPerformed(ActionEvent arg0) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected == null) {
            AppCore.getInstance().getMsgGenerator().generateMsg("Morate odabrati neki cvor iz Project Explorera", TipPoruke.OBAVJESTENJE);
            return;
        }
        if (selected.getMapNode() instanceof Element) {
            AppCore.getInstance().getMsgGenerator().generateMsg("Ne mozete dodati 'decu' na elemente", TipPoruke.GRESKA);
            return;
        }
        MainFrame.getInstance().getMapTree().addChild(selected, null);
    }

}
