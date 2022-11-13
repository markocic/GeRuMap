package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.core.ISubscriber;

import javax.swing.*;

public class RightPanel extends JPanel implements ISubscriber {
    private JLabel projectNameLabel;
    private JLabel authorNameLabel;
    private TabbedPane tabbedPane;

    public RightPanel() {
        this.projectNameLabel = new JLabel("project name");
        this.authorNameLabel = new JLabel("author name");
        this.tabbedPane = new TabbedPane();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(projectNameLabel);
        this.add(authorNameLabel);
        this.add(tabbedPane);

    }

    @Override
    public void update(Object notification) {
        // ne radi nista sad

    }
}
