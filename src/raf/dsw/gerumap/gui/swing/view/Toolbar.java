package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.controller.ExitAction;
import raf.dsw.gerumap.gui.swing.controller.NewProjectAction;
import raf.dsw.gerumap.gui.swing.controller.NewSomethingAction;
import raf.dsw.gerumap.gui.swing.controller.QuitAction;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JToolBar {

    JButton tbIzadji;
    JButton tbNovi;

    public Toolbar() {
        init();
    }


    private void init() {
        tbNovi = new JButton(new NewProjectAction());
        tbIzadji = new JButton(new ExitAction());
        this.add(tbNovi);
        this.add(tbIzadji);



    }
}
