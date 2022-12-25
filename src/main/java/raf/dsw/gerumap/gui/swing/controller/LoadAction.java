package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.logger.TipPoruke;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class LoadAction extends AbstractGerumapAction{


    public LoadAction() {
        putValue(SMALL_ICON, loadIcon("/images/load.png"));
        putValue(NAME, "Load");
        putValue(SHORT_DESCRIPTION, "Load .json file");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //pravi novi modal za file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(".json", "json"));

        if (fileChooser.showOpenDialog(MainFrame.getInstance()) != JFileChooser.APPROVE_OPTION) return;

        try {
            File file = fileChooser.getSelectedFile();

            if (!file.getName().endsWith(".json")) {
                AppCore.getInstance().getMsgGenerator().generateMsg("Projekat mora biti u JSON formatu", TipPoruke.GRESKA);
                return;
            }

            Project p = AppCore.getInstance().getGsonSerializer().loadProject(file);
            MainFrame.getInstance().getMapTree().loadProject(p);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
