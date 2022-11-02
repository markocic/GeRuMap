package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.controller.ExitAction;
import raf.dsw.gerumap.gui.swing.controller.InfoAction;
import raf.dsw.gerumap.gui.swing.controller.NewProjectAction;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar() {
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        file.add(MainFrame.getInstance().getActionManager().getExitAction());
        file.add(MainFrame.getInstance().getActionManager().getNewProjectAction());

        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        help.add(MainFrame.getInstance().getActionManager().getAuthorAction());
        help.add(MainFrame.getInstance().getActionManager().getInfoAction());

        this.add(file);
        this.add(help);
    }
}
