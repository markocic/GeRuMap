package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractGerumapAction{
    public UndoAction() {
        putValue(SMALL_ICON, loadIcon("/images/undo.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo your recent action");
        setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //na panelu vraca desavanje nazad
        MainFrame.getInstance().getRightPanel().getCurrentMapView().getMapa().getCommandManager().undoCommand();
//        ((MindMap) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode()).getCommandManager().undoCommand();
    }
}
