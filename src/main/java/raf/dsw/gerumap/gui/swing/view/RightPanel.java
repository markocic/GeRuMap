package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.observer.ISubscriber;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;

public class RightPanel extends JPanel implements ISubscriber {
    private JLabel projectNameLabel;
    private JLabel authorNameLabel;
    private TabbedPane tabbedPane;

    public RightPanel() {
        this.projectNameLabel = new JLabel("project name");
        this.authorNameLabel = new JLabel("author name");
        this.tabbedPane = new TabbedPane(JTabbedPane.TOP);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(projectNameLabel);
        this.add(authorNameLabel);
        this.add(tabbedPane);

    }

    @Override
    public void update(Object notification) {
        // ne radi nista sad
//        if (notification instanceof Project) {
//            Project project = (Project) notification;
//            this.authorNameLabel.setText(project.getAuthor());
//            this.projectNameLabel.setText(project.getName());
//
//            this.tabbedPane.removeAll();
//
//            System.out.println((project.getChildren().size()));
//            for (MapNode mindMap : project.getChildren()) {
//                this.tabbedPane.addTab(mindMap.getName(), new JLabel(mindMap.getName()));
//                System.out.println("HERE");
//            }
//        }
//
//        if (notification instanceof MindMap) {
//            MindMap mindMap = (MindMap) notification;
//            mindMap.getParent().notifySubscribers(mindMap.getParent());
//        }
    }

    @Override
    public void updateAuthorName(String newAuthor) {
        this.authorNameLabel.setText(newAuthor);
    }

    @Override
    public void updateProjectNameChanged(String newProjectName) {
        this.projectNameLabel.setText(newProjectName);
    }

    @Override
    public void updateMindMapCreated(String mindMapName) {
        this.tabbedPane.addTab(mindMapName, new MapView(mindMapName));
    }

    @Override
    public void updateMindMapDeleted(String name) {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            if (tabbedPane.getTitleAt(i) == name) {
                tabbedPane.removeTabAt(i);
                return;
            }
        }
    }

    @Override
    public void updateProjectOpened(Object project) {
        if (!(project instanceof Project)) return; // TODO: ovde moze error da ne moze da se otvori nesto sto nije project
        Project openedProject = (Project) project;
        this.authorNameLabel.setText(openedProject.getAuthor());
        this.projectNameLabel.setText(openedProject.getName());

        this.tabbedPane.removeAll();

        System.out.println((openedProject.getChildren().size()));
        for (MapNode mindMap : openedProject.getChildren()) {
            this.tabbedPane.addTab(mindMap.getName(), new MapView(mindMap.getName()));
        }
    }

    @Override
    public void updateMindMapNameChanged(String oldName, String newName) {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            if (tabbedPane.getTitleAt(i) == oldName) {
                tabbedPane.setTitleAt(i, newName);
                return;
            }
        }
    }

    @Override
    public void updateOpenedProjectDeleted() {
        this.projectNameLabel.setText("project name");
        this.authorNameLabel.setText("author name");
        tabbedPane.removeAll();
    }
}
