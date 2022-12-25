package raf.dsw.gerumap.gui.swing.view;


import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.gui.swing.grafika.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.grafika.painter.VezaPainter;
import raf.dsw.gerumap.gui.swing.observer.GrafikaSubscriber;
import raf.dsw.gerumap.repository.command.CommandType;
import raf.dsw.gerumap.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class MapView extends JPanel implements GrafikaSubscriber{

    ArrayList<ElementPainter> painters;
    ArrayList<ElementPainter> selectedPainters;
    private Rectangle2D selekcijaRect = new Rectangle2D.Double();
    private double zoom = 1;
    private MindMap mapa;
    private JScrollPane jScrollPane;
    private AffineTransform transform = new AffineTransform();

    public MapView() {
        this.addMouseListener(new MouseController());
        this.addMouseWheelListener(new MouseController());
        this.addMouseMotionListener(new MouseMotionController());
        this.setBackground(Color.WHITE);
        this.painters = new ArrayList<>();
        this.selectedPainters = new ArrayList<>();

    }

    public MapView(MindMap map) {
        this();
        this.mapa = map;
        this.mapa.addGrafikaSubscriber(this);
    }

    public AffineTransform getTransform() {
        return transform;
    }

    public void setTransform(AffineTransform transform) {
        this.transform = transform;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.transform(transform);
        if (painters.isEmpty()) return;
        // ovo bi trebalo da iterira kroz sve paintere u mapi i iscrta ih
        for (ElementPainter painter : painters) {
            painter.draw(g2);
        }

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1));
        g2.draw(selekcijaRect);
        g2.dispose();
    }

    public List<ElementPainter> getPainters() {
        return painters;
    }

    public void addPainter(ElementPainter painter) {
        if (painter == null) return;
        if (painters.contains(painter)) return;
        painters.add(painter);
    }

    public void addPainterAtIndex(ElementPainter painter, int index) {
        if (painter == null) return;
        if (painters.contains(painter)) return;
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

    public void deletePainterFromModel(ElementModel model) {
        for (ElementPainter painter : painters) {
            if (painter.getElement().equals(model)) {
                selectedPainters.remove(painter);
                painters.remove(painter);
                model.removeGrafikaSubscriber(painter);
                return;
            }

        }
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
    public void update(CommandType commandType, Object obj) {

        if (commandType == CommandType.DODAJ_POJAM) {
            ElementModel pojamModel = (PojamModel) obj;
            pojamModel.addGrafikaSubscriber(this);

            ElementPainter painter = new PojamPainter(pojamModel);
            addPainter(painter);
        }

        else if (commandType == CommandType.OBRISI_POJAM) {
            ElementModel pojamModel = (PojamModel) obj;
            deletePainterFromModel(pojamModel);
        }

        else if (commandType == CommandType.DODAJ_VEZU) {
            VezaModel vezaModel = (VezaModel) obj;
            vezaModel.addGrafikaSubscriber(this);

            ElementPainter painter = new VezaPainter(vezaModel);
            addPainterAtIndex(painter, 0);
        }

        else if (commandType == CommandType.OBRISI_VEZU) {
            VezaModel vezaModel = (VezaModel) obj;

            deletePainterFromModel(vezaModel);
        }

        else if (commandType == CommandType.MULTI_BRISANJE) {
            ArrayList<ElementModel> models = (ArrayList<ElementModel>) obj;

            for (ElementModel model : models) {
                deletePainterFromModel(model);
            }

        }

        repaint();
    }

    @Override
    public void updateShape(Object pocetnaTacka, Object krajnjaTacka) {}

    public class MouseController extends MouseAdapter implements MouseWheelListener{

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            MainFrame.getInstance().getRightPanel().mouseWheelMovedMediator(e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            Point2D point = getMousePoint(e.getX(), e.getY());
            MainFrame.getInstance().getRightPanel().mousePressedMediator((int) point.getX(), (int) point.getY(), ((MapView) e.getSource()));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Point2D point = getMousePoint(e.getX(), e.getY());
            MainFrame.getInstance().getRightPanel().mouseReleasedMediator((int) point.getX(), (int) point.getY(), ((MapView) e.getSource()));
        }
    }

    public class MouseMotionController extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            Point2D point = getMousePoint(e.getX(), e.getY());
            MainFrame.getInstance().getRightPanel().mouseDraggedMediator((int) point.getX(), (int) point.getY(), ((MapView) e.getSource()));
        }
    }

    public MindMap getMapa() {
        return mapa;
    }

    public void setMapa(MindMap mapa) {
        this.mapa = mapa;
    }

    public Point2D getMousePoint(int x, int y) {
        Point2D oldPoint = new Point(x, y);
        Point2D point = null;
        try {
            point = transform.inverseTransform(oldPoint, oldPoint);
        } catch (NoninvertibleTransformException ex) {
            throw new RuntimeException(ex);
        }

        return point;
    }

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }
}
