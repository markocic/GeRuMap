package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MapView extends JPanel{

    List<ElementPainter> painters;
    private MindMap mapa;

    public MapView() {
        this.addMouseListener(new MouseController());
        setSize(400,400);
        this.setBackground(Color.WHITE);
    }

    public List<ElementPainter> getPainters() {
        return painters;
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
                MainFrame.getInstance().getRightPanel().mousePressedMediator(e.getX(), e.getY(), ((MapView) e.getSource()).getMapa());
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                MainFrame.getInstance().getRightPanel().mouseReleasedMediator(e.getX(), e.getY(), ((MapView) e.getSource()).getMapa());
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                MainFrame.getInstance().getRightPanel().mouseDraggedMediator(e.getX(), e.getY(), ((MapView) e.getSource()).getMapa());
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
