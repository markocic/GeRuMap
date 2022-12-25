package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.logger.TipPoruke;
import raf.dsw.gerumap.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class SaveAsTemplateAction extends AbstractGerumapAction {
    public SaveAsTemplateAction() {
        putValue(SMALL_ICON, loadIcon("/images/save.png"));
        putValue(NAME, "Save as template");
        putValue(SHORT_DESCRIPTION, "Save a template");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "/src/main/resources/templates");

        MindMap mindMap = getMapToSave();

        if (mindMap == null) {
            AppCore.getInstance().getMsgGenerator().generateMsg("Morate otvoriti tab mape koju zelite da sacuvate kao sablon, ili da izaberete tu mapu iz Project Explorer-a", TipPoruke.GRESKA);
            return;
        }

        fileChooser.setSelectedFile(new File(mindMap.getName() + ".json"));
        mindMap.setTemplate(true);

        if (fileChooser.showSaveDialog(MainFrame.getInstance()) != JFileChooser.APPROVE_OPTION) return;

        File projectFile = fileChooser.getSelectedFile();

        // ukoliko template nije u .json formatu, sacuvati ga tako
        String projectPath = projectFile.getPath();
        if (!projectPath.endsWith(".json")) projectPath = projectPath.concat(".json");

        AppCore.getInstance().getGsonSerializer().saveTemplate(mindMap, projectPath);
    }
}
