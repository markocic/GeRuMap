package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.observer.ISubscriber;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.state.StateManager;

import javax.swing.*;

public class RightPanel extends JPanel implements ISubscriber {
    private final JLabel projectNameLabel;
    private final JLabel authorNameLabel;
    private final TabbedPane tabbedPane;
    private StateManager stateManager;

    public RightPanel() {
        this.projectNameLabel = new JLabel("project name");
        this.authorNameLabel = new JLabel("author name");
        this.tabbedPane = new TabbedPane(JTabbedPane.TOP);
        this.stateManager = new StateManager();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(projectNameLabel);
        this.add(authorNameLabel);
        this.add(tabbedPane);

    }

    @Override
    public void update(Object notification) {
    }
    // State metode
    public void startBrisanjeState() {
        this.stateManager.setBrisanjeState();
    }

    public void startDodajPojamState() {
        this.stateManager.setDodajPojamState();
    }

    public void startNapraviVezuState() {
        this.stateManager.setNapraviVezuState();
    }

    public void startPomeranjeState() {
        this.stateManager.setPomeranjeState();
    }

    public void startSelekcijaState() {
        this.stateManager.setSelekcijaState();
    }

    public void startZumiranjeState() {
        this.stateManager.setZumiranjeState();
    }
    public void startPodesavanjaState() {
        this.stateManager.setPodesavanjaState();
    }

    // mis eventovi
    public void misKliknut(int x, int y, MindMap map) {
        System.out.println("x: " + x + " y: " + y + " mapa ime: " + map.getName());
        this.stateManager.getCurrentState().performAction(x, y, map);
    }

    // Observer metode
    @Override
    public void updateAuthorName(String newAuthor) {
        this.authorNameLabel.setText(newAuthor);
    }

    @Override
    public void updateProjectNameChanged(String newProjectName) {
        this.projectNameLabel.setText(newProjectName);
    }

    @Override
    public void updateMindMapCreated(MindMap mindMap) {
        this.tabbedPane.addTab(mindMap.getName(), new MapView(mindMap));
    }

    @Override
    public void updateMindMapDeleted(String name) {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            if (tabbedPane.getTitleAt(i).equals(name)) {
                tabbedPane.removeTabAt(i);
                return;
            }
        }
    }

    @Override
    public void updateProjectOpened(Object project) {
        if (!(project instanceof Project openedProject)) return;
        this.authorNameLabel.setText(openedProject.getAuthor());
        this.projectNameLabel.setText(openedProject.getName());

        this.tabbedPane.removeAll();

        System.out.println((openedProject.getChildren().size()));
        for (MapNode mindMap : openedProject.getChildren()) {
            this.tabbedPane.addTab(mindMap.getName(), new MapView((MindMap) mindMap));
        }
    }

    @Override
    public void updateMindMapNameChanged(String oldName, String newName) {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            if (tabbedPane.getTitleAt(i).equals(oldName)) {
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

    public StateManager getStateManager() {
        return stateManager;
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }





}
