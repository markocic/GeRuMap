package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
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

        Project project = (Project) ((MapTree) MainFrame.getInstance().getMapTree()).getOpenedNode().getMapNode();
        File projectFile = null;


        if (fileChooser.showSaveDialog(MainFrame.getInstance()) != JFileChooser.APPROVE_OPTION) return;

        projectFile = fileChooser.getSelectedFile();
        project.setPath(projectFile.getPath());

        AppCore.getInstance().getGsonSerializer().saveProject(project);

    }
}
