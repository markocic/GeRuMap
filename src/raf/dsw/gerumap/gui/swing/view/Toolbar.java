package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.controller.ExitAction;
import raf.dsw.gerumap.gui.swing.controller.NewProjectAction;


import javax.swing.*;
import java.awt.*;

public class Toolbar extends JToolBar {



    public Toolbar() {
        super(HORIZONTAL);
        setFloatable(false);
        this.add(MainFrame.getInstance().getActionManager().getExitAction());
        this.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
    }
}
