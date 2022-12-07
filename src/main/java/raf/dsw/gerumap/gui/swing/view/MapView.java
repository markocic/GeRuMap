package raf.dsw.gerumap.gui.swing.view;


import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.observer.GrafikaSubscriber;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.state.concrete.DodajPojamState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class MapView extends JPanel implements GrafikaSubscriber{

    List<ElementPainter> painters;
    List<ElementPainter> selectedPainters;
    private Rectangle2D selekcijaRect = new Rectangle2D.Double();
    private MindMap mapa;

    public MapView() {
        this.addMouseListener(new MouseController());
        this.addMouseMotionListener(new MouseMotionController());
        setSize(400,400);
        this.setBackground(Color.WHITE);
        this.painters = new ArrayList<>();
        this.selectedPainters = new ArrayList<>();

    }

    public MapView(MindMap map) {
        this();
        this.mapa = map;
        this.mapa.addGrafikaSubscriber(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(selekcijaRect);
        if (painters.isEmpty()) return;
        // ovo bi trebalo da iterira kroz sve paintere u mapi i iscrta ih sve
        for (ElementPainter painter : painters) {
            painter.draw(g2);
        }
    }

    public List<ElementPainter> getPainters() {
        return painters;
    }

    public void addPainter(ElementPainter painter) {
        if (painter == null) return;
        painters.add(painter);
    }

    public void addPainterAtIndex(ElementPainter painter, int index) {
        if (painter == null) return;
        painters.add(index, painter);
    }

    public void removePainter(ElementPainter painter) {
        if (painter == null || painters.isEmpty()) return;
        painters.remove(painter);
    }

    public void removeAllPainters(ArrayList<ElementPainter> paintersList) {
        if (paintersList.isEmpty() || painters.isEmpty()) return;
        painters.removeAll(paintersList);
        for (ElementPainter painter : paintersList) {
            mapa.removeModel(painter.getElement());
        }
    }

    public void addSelectedPainter(ElementPainter painter) {
        if (painter == null) return;
        painter.setSelected(true);
        selectedPainters.add(painter);
        recolorSelected();
    }

    public void removeSelectedPainter(ElementPainter painter) {
        if (painter == null || !selectedPainters.isEmpty()) return;
        painter.setSelected(false);
        selectedPainters.remove(painter); // remove vec proverava da li element postoji u nizu
        recolorSelected();
    }

    public void deleteSelectedPainters() {
        for (ElementPainter painter : selectedPainters) {
            painters.remove(painter);
            mapa.removeModel(painter.getElement());
        }
        deselectAll();
    }

    public void deselectAll() {
        for (ElementPainter painter : selectedPainters) {
            painter.setSelected(false);
        }
        selectedPainters.clear();
        recolorSelected();
    }

    public void recolorSelected() {
        for (ElementPainter painter : painters) {
            painter.getElement().setColor(Color.BLACK);
        }
        for (ElementPainter painter : selectedPainters) {
            painter.getElement().setColor(Color.RED);
        }
    }

    public List<ElementPainter> getSelectedPainters() {
        return selectedPainters;
    }

    public void setSelectedPainters(List<ElementPainter> selectedPainters) {
        this.selectedPainters = selectedPainters;
    }

    public void setPainters(List<ElementPainter> painters) {
        this.painters = painters;
    }

    public Rectangle2D getSelekcijaRect() {
        return selekcijaRect;
    }

    public void setSelekcijaRect(Rectangle2D selekcijaRect) {
        this.selekcijaRect = selekcijaRect;
        this.repaint();
    }

    @Override
    public void update() {
        repaint();
    }


    public class MouseController extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1 && e.getSource() instanceof MapView) {
                MainFrame.getInstance().getRightPanel().mousePressedMediator(e.getX(), e.getY(), ((MapView) e.getSource()));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                MainFrame.getInstance().getRightPanel().mouseReleasedMediator(e.getX(), e.getY(), ((MapView) e.getSource()));
            }
        }
    }

    public class MouseMotionController extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            MainFrame.getInstance().getRightPanel().mouseDraggedMediator(e.getX(), e.getY(), ((MapView) e.getSource()));
        }
    }

    public MindMap getMapa() {
        return mapa;
    }

    public void setMapa(MindMap mapa) {
        this.mapa = mapa;
    }
}
