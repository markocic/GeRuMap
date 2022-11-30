package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.AppCore;

import javax.swing.*;

public class Paleta extends JToolBar {

    public Paleta() {
        super(JToolBar.VERTICAL);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(MainFrame.getInstance().getActionManager().getNewProjectAction());



    }





}
