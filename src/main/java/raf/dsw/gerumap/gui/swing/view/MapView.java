package raf.dsw.gerumap.gui.swing.view;


import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.state.concrete.DodajPojamState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MapView extends JPanel{

    List<ElementPainter> painters;
    List<ElementPainter> selectedPainters;
    private MindMap mapa;

    public MapView() {
        this.addMouseListener(new MouseController());
        setSize(400,400);
        this.setBackground(Color.WHITE);
        this.painters = new ArrayList<>();
        this.selectedPainters = new ArrayList<>();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
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
        repaint();
    }

    public void addSelectedPainter(ElementPainter painter) {
        if (painter == null) return;
        selectedPainters.add(painter);
        recolorSelected();
        repaint();
    }

    public void removeSelectedPainter(ElementPainter painter) {
        if (painter == null && !selectedPainters.isEmpty()) return;
        selectedPainters.remove(painter); // remove vec proverava da li element postoji u nizu
        recolorSelected();
        repaint();
    }

    public void deleteSelectedPainters() {
        for (ElementPainter painter : selectedPainters) {
            painters.remove(painter);
        }
        deselectAll();
    }

    public void deselectAll() {
        selectedPainters.clear();
        recolorSelected();
        repaint();
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

    public MapView(MindMap map) {
        this();
        this.mapa = map;
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

        @Override
        public void mouseDragged(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                MainFrame.getInstance().getRightPanel().mouseDraggedMediator(e.getX(), e.getY(), ((MapView) e.getSource()));
            }
        }
    }

    public MindMap getMapa() {
        return mapa;
    }

    public void setMapa(MindMap mapa) {
        this.mapa = mapa;
    }
}
