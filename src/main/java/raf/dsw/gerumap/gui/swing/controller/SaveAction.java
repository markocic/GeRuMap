package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.logger.TipPoruke;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class SaveAction extends AbstractGerumapAction{

    public SaveAction() {
        putValue(SMALL_ICON, loadIcon("/images/save.png"));
        putValue(NAME, "Save");
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
        File projectFile = null;

        if (project.getPath() == null || project.getPath().isEmpty()) {
            if (fileChooser.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                projectFile = fileChooser.getSelectedFile();
                project.setPath(projectFile.getPath());
            } else {
                return;
            }

        }

        AppCore.getInstance().getGsonSerializer().saveProject(project);

    }
}
