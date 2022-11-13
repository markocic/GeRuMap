package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.core.ISubscriber;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;
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
        if (notification instanceof Project) {
            Project project = (Project) notification;
            this.authorNameLabel.setText(project.getAuthor());
            this.projectNameLabel.setText(project.getName());

            this.tabbedPane.removeAll();

            System.out.println((project.getChildren().size()));
            for (MapNode mindMap : project.getChildren()) {
                this.tabbedPane.addTab(mindMap.getName(), new JLabel(mindMap.getName()));
                System.out.println("HERE");
            }
        }

//        if (notification instanceof MindMap) {
//            MindMap mindMap = (MindMap) notification;
//            this.tabbedPane.removeAll();
//
//            for (MapNode curr_mindMap : ((Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode()).getChildren()) {
//                this.tabbedPane.addTab(curr_mindMap.getName(), new JLabel(curr_mindMap.getName()));
//                System.out.println("HERE");
//            }
//        }
    }
}
