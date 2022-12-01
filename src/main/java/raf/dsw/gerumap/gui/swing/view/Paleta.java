package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.AppCore;

import javax.swing.*;
import java.awt.*;

public class Paleta extends JToolBar {

    public Paleta() {
        super(JToolBar.VERTICAL);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.add(MainFrame.getInstance().getActionManager().getSelekcijaAction());
        this.add(MainFrame.getInstance().getActionManager().getPomeranjeAction());
        this.add(MainFrame.getInstance().getActionManager().getZumiranjeAction());
        this.add(MainFrame.getInstance().getActionManager().getDodajPojamAction());
        this.add(MainFrame.getInstance().getActionManager().getNapraviVezuAction());
        this.add(MainFrame.getInstance().getActionManager().getBrisanjeAction());



    }





}
