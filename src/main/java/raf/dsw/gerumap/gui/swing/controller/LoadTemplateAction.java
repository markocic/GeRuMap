package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.implementation.MindMap;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class LoadTemplateAction extends AbstractGerumapAction {
    public LoadTemplateAction() {
        putValue(SMALL_ICON, loadIcon("/images/load.png"));
        putValue(NAME, "Load template");
        putValue(SHORT_DESCRIPTION, "Load template");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "/src/main/resources/templates");
        fileChooser.setFileFilter(new FileNameExtensionFilter(".json", "json"));

        if (fileChooser.showOpenDialog(MainFrame.getInstance()) != JFileChooser.APPROVE_OPTION) return;

        MindMap templateMap = null;
        try {
            File file = fileChooser.getSelectedFile();
            templateMap = AppCore.getInstance().getGsonSerializer().loadTemplate(file);

        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

        MindMap currentMap = MainFrame.getInstance().getRightPanel().getCurrentMapView().getMapa();

        for (ElementModel model : templateMap.getModels()) {
            currentMap.addModel(model);
        }
    }
}
