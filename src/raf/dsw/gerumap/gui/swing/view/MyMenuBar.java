package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.controller.ExitAction;

import javax.swing.*;

import java.awt.*;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar() {
        init();
    }
    JMenu file = new JMenu("File");

    JMenuItem newProject = new JMenuItem("New Project", new ImageIcon("../controller/images/plus_icon.png"));
    JMenuItem exit = new JMenuItem(new ExitAction());


    private void init() {
        this.add(file);
        file.add(newProject);
        file.add(exit);
    }


}
