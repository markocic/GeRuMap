package raf.dsw.gerumap.gui.swing.view;


import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.observer.GrafikaSubscriber;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.state.concrete.ZumiranjeState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class MapView extends JPanel implements GrafikaSubscriber{

    ArrayList<ElementPainter> painters;
    ArrayList<ElementPainter> selectedPainters;
    private Rectangle2D selekcijaRect = new Rectangle2D.Double();
    private MindMap mapa;

    private  double zoomFaktor = 1;
    private  double prevZoomFaktor = 1;
    private double xOff = 0;
    private double yOff = 0;
    private int xDif;
    private int yDif;
    private Point start;

    private boolean flagZumiranja = true;

    private AffineTransform transform = new AffineTransform();

    public MapView() {
        this.addMouseListener(new MouseController());
        this.addMouseWheelListener(new MouseController());
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

        if(flagZumiranja) {
            double xRel = MouseInfo.getPointerInfo().getLocation().getX() - getLocationOnScreen().getX();
            double yRel = MouseInfo.getPointerInfo().getLocation().getY() - getLocationOnScreen().getY();
            double zoomDiv = zoomFaktor / prevZoomFaktor;
            //xOff = (zoomDiv) * (xOff) + (1 - zoomDiv) * xRel;
            yOff = (zoomDiv) * (yOff) + (1 - zoomDiv) * yRel;
            xOff = (zoomDiv) * (xOff);

            transform.translate(xOff, yOff);
            transform.scale(zoomFaktor, zoomFaktor);
            prevZoomFaktor = zoomFaktor;

            g2.transform(transform);
        }
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
        if (painter == null || selectedPainters.contains(painter)) return;
        painter.setSelected(true);
        selectedPainters.add(painter);
    }

    public void addAllSelectedPainters(ArrayList<ElementPainter> paintersList) {
        if (paintersList.isEmpty()) return;
        for (ElementPainter painter : paintersList) {
            if (selectedPainters.contains(painter)) continue;

            painter.setSelected(true);
            selectedPainters.add(painter);
        }
    }

    public void removeSelectedPainter(ElementPainter painter) {
        if (painter == null || !selectedPainters.isEmpty()) return;
        painter.setSelected(false);
        selectedPainters.remove(painter); // remove vec proverava da li element postoji u nizu
    }

    public void deleteSelectedPainters() {
        for (ElementPainter painter : selectedPainters) {
            painters.remove(painter);
            mapa.removeModel(painter.getElement());
        }
        
        selectedPainters.clear();
    }

    public void deselectAll() {
        for (ElementPainter painter : selectedPainters) {
            painter.setSelected(false);
        }
        selectedPainters.clear();
    }


    public ArrayList<ElementPainter> getSelectedPainters() {
        return selectedPainters;
    }

    public void setSelectedPainters(ArrayList<ElementPainter> selectedPainters) {
        this.selectedPainters = selectedPainters;
    }

    public void setPainters(ArrayList<ElementPainter> painters) {
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

    @Override
    public void updateShape(Point pocetnaTacka, Point krajnjaTacka) {}


    public class MouseController extends MouseAdapter implements MouseWheelListener{

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            if (e.getWheelRotation() > 0) {
                zoomFaktor = 1;
                zoomFaktor /=1.01;
                System.out.println("ZOOM OUT");
                update();
            }
            if(e.getWheelRotation() < 0){
                zoomFaktor = 1;
                zoomFaktor *= 1.01;
                System.out.println("ZOOM IN");
                update();
            }
        }

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

    public boolean isFlagZumiranja() {
        return flagZumiranja;
    }

    public void setFlagZumiranja(boolean flagZumiranja) {
        this.flagZumiranja = flagZumiranja;
    }
}
