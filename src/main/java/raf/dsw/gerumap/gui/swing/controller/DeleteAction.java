package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.controller.MapTreeCellEditor;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractGerumapAction{

    MapTreeItem parent;
    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_DELETE,InputEvent.ALT_MASK));
        putValue(NAME, "del");
        putValue(SHORT_DESCRIPTION, "del");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getMapTree().deleteChild(MainFrame.getInstance().getMapTree().getSelectedNode());
    }
}
