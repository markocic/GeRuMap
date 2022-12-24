package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class SaveAsTemplateAction extends AbstractGerumapAction {
    public SaveAsTemplateAction() {
        putValue(SMALL_ICON, loadIcon("/images/save.png"));
        putValue(NAME, "Save as Template");
        putValue(SHORT_DESCRIPTION, "Save your work");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "/src/main/resources/templates");
        MindMap mindMap = MainFrame.getInstance().getRightPanel().getCurrentMapView().getMapa();
        fileChooser.setSelectedFile(new File(mindMap.getName() + ".json"));
        mindMap.setTemplate(true);
        File projectFile = null;

            if (fileChooser.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                projectFile = fileChooser.getSelectedFile();
            } else return;

        AppCore.getInstance().getGsonSerializer().saveTemplate(mindMap, projectFile.getPath());
    }
}
