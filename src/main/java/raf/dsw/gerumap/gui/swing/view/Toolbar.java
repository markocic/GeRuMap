package raf.dsw.gerumap.gui.swing.view;


import javax.swing.*;

public class Toolbar extends JToolBar {
    public Toolbar() {
        super(HORIZONTAL);
        setFloatable(false);
        this.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        this.add(MainFrame.getInstance().getActionManager().getOpenProjectAction());
        this.add(MainFrame.getInstance().getActionManager().getSaveAction());
        this.add(MainFrame.getInstance().getActionManager().getSavePictureAction());
        this.add(MainFrame.getInstance().getActionManager().getLoadAction());
        this.add(MainFrame.getInstance().getActionManager().getAuthorAction());
        this.add(MainFrame.getInstance().getActionManager().getDeleteAction());
        this.add(MainFrame.getInstance().getActionManager().getUndoAction());
        this.add(MainFrame.getInstance().getActionManager().getRedoAction());
        this.add(MainFrame.getInstance().getActionManager().getExitAction());
    }
}
