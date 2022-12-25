package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.logger.TipPoruke;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class SaveAsAction extends AbstractGerumapAction {
    public SaveAsAction() {
        putValue(SMALL_ICON, loadIcon("/images/save.png"));
        putValue(NAME, "Save As...");
        putValue(SHORT_DESCRIPTION, "Save your work");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //otvara modal sa filechooserom
        JFileChooser fileChooser = new JFileChooser();
        Project project = getProjectToSave();

        if (project == null) {
            AppCore.getInstance().getMsgGenerator().generateMsg("Projekat koji zelite da sacuvate mora bili otvoren ili selektovan u Project Explorer-u", TipPoruke.GRESKA);
            return;
        }

        fileChooser.setSelectedFile(new File(project.getName() + ".json"));

        if (fileChooser.showSaveDialog(MainFrame.getInstance()) != JFileChooser.APPROVE_OPTION) return;

        File projectFile = fileChooser.getSelectedFile();
        project.setPath(projectFile.getPath());

        // ako projekat nije sacuvan u json formatu, automatski ga tako sacuvati
        if (!project.getPath().endsWith(".json")) {
            project.setPath(project.getPath() + ".json");
        }

        AppCore.getInstance().getGsonSerializer().saveProject(project);

    }
}
