package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.controller.MapTreeCellEditor;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractGerumapAction{

    MapTree mapTree;
    MapTreeItem parent;
    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_DELETE,InputEvent.ALT_MASK));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mapTree.deleteChild(  parent ,mapTree.getSelectedNode());
    }
}
