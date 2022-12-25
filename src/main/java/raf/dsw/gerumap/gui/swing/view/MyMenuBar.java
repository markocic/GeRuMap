package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;

import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar() {
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        file.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        file.add(MainFrame.getInstance().getActionManager().getOpenProjectAction());
        file.add(MainFrame.getInstance().getActionManager().getSaveAction());
        file.add(MainFrame.getInstance().getActionManager().getSaveAsAction());
        file.add(MainFrame.getInstance().getActionManager().getSaveAsTemplate());
        file.add(MainFrame.getInstance().getActionManager().getSavePictureAction());
        file.add(MainFrame.getInstance().getActionManager().getLoadAction());
        file.add(MainFrame.getInstance().getActionManager().getLoadTemplateAction());
        file.add(MainFrame.getInstance().getActionManager().getExitAction());

        JMenu edit = new JMenu("Edit");
        edit.setMnemonic(KeyEvent.VK_E);
        edit.add(MainFrame.getInstance().getActionManager().getUndoAction());
        edit.add(MainFrame.getInstance().getActionManager().getRedoAction());
        edit.add(MainFrame.getInstance().getActionManager().getDeleteAction());

        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        help.add(MainFrame.getInstance().getActionManager().getAuthorAction());
        help.add(MainFrame.getInstance().getActionManager().getInfoAction());

        this.add(file);
        this.add(edit);
        this.add(help);
    }
}
