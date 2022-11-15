package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractGerumapAction{

    MapTreeItem parent;
    public DeleteAction() {
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_DELETE);
        putValue(SMALL_ICON, loadIcon("/images/deleteStuff.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getMapTree().deleteChild(MainFrame.getInstance().getMapTree().getSelectedNode());
    }
}
