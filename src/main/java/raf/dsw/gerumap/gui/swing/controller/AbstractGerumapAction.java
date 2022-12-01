package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.net.URL;

public abstract class AbstractGerumapAction extends AbstractAction {

    public Icon loadIcon(String fileName){

        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        else {
            System.err.println("Resource not found: " + fileName);
        }
        return icon;
    }

    public void setActive(AbstractGerumapAction action) {
        MainFrame.getInstance().getActionManager().getBrisanjeAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getDodajPojamAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getNapraviVezuAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getPomeranjeAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getSelekcijaAction().setEnabled(true);
        MainFrame.getInstance().getActionManager().getZumiranjeAction().setEnabled(true);

        action.setEnabled(false);
    }


}