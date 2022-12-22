package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.implementation.MindMap;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractGerumapAction{

    public RedoAction() {
        putValue(SMALL_ICON, loadIcon("/images/redo.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo an action");
        setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //omogucava vadjenje i brisanje iz "stack ili liste dogadjaja" desavanja
        ((MindMap) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode()).getCommandManager().doCommand();
    }
}
