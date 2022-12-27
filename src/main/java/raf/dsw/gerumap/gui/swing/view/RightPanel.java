package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.SwingGui;
import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.VezaPainter;
import raf.dsw.gerumap.gui.swing.observer.ISubscriber;
import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.gui.swing.state.StateManager;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseWheelEvent;

public class RightPanel extends JPanel implements ISubscriber {
    private final JLabel projectNameLabel;
    private final JLabel authorNameLabel;
    private final TabbedPane tabbedPane;
    private StateManager stateManager;
    private MapView currentMapView;

    public RightPanel() {
        this.projectNameLabel = new JLabel("project name");
        this.authorNameLabel = new JLabel("author name");
        this.tabbedPane = new TabbedPane(JTabbedPane.TOP);
        this.stateManager = new StateManager();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(projectNameLabel);
        this.add(authorNameLabel);
        this.add(tabbedPane);

        ChangeListener changeListener = e -> {
            JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
            if (sourceTabbedPane.getSelectedComponent() == null) {
                currentMapView = null;
                return;
            }
            currentMapView = (MapView) ((JScrollPane) sourceTabbedPane.getSelectedComponent()).getViewport().getView();
            ((SwingGui) AppCore.getInstance().getGui()).refreshUndoRedoButtons();
        };

        tabbedPane.addChangeListener(changeListener);

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

    public void startCentralniState() {
        this.stateManager.setCentralniState();
    }

    // mis eventovi
    public void mousePressedMediator(int x, int y, MapView map) {
        this.stateManager.getCurrentState().mousePressedState(x, y, map);
    }

    public void mouseReleasedMediator(int x, int y, MapView map) {
        this.stateManager.getCurrentState().mouseReleasedState(x, y, map);
    }


    public void mouseDraggedMediator(int x, int y, MapView map) {
        this.stateManager.getCurrentState().mouseDraggedState(x, y, map);
    }

    public void mouseWheelMovedMediator(MouseWheelEvent e) {
        this.stateManager.getCurrentState().mouseWheelMoved(e);
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
        setupMindMap(mindMap);
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

        for (MapNode mindMap : openedProject.getChildren()) {

            setupMindMap(mindMap);
        }
    }

    private void setupMindMap(MapNode mindMap) {
        MapView mapView = new MapView((MindMap) mindMap);
        mapView.setPreferredSize(new Dimension(800, 400));
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(mapView);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        jScrollPane.setSize(mapView.getSize());
        mapView.setjScrollPane(jScrollPane);


        for (ElementModel model : ((MindMap) mindMap).getModels()) {
            if (model instanceof PojamModel) mapView.addPainter(new PojamPainter(model));
            else if (model instanceof VezaModel) mapView.addPainter(new VezaPainter(model));

            model.addGrafikaSubscriber(mapView);
        }

        this.tabbedPane.addTab(mindMap.getName(), jScrollPane);
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
        ((MapTree) MainFrame.getInstance().getMapTree()).setOpenedNode(null);
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }


    public TabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public MapView getCurrentMapView() {
        return currentMapView;
    }

    public void setCurrentMapView(MapView currentMapView) {
        this.currentMapView = currentMapView;
    }
}
