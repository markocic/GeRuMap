package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.state.concrete.DodajPojamState;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MapView extends JInternalFrame{

    //List<Painter> painters;
    private JPanel radnaPovrsina;
    private MindMap mapa;



    public MapView() {
        super(" ",false,false,false,true);
        this.addMouseListener(new MouseController());
        setIconifiable(true);
        setClosable(true);
        setSize(400,400);
        setVisible(true);
        this.setDefaultCloseOperation(2);

    }

    public MapView(MindMap map) {
        this();
        this.mapa = map;
    }

    public class MouseController extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1 && e.getSource() instanceof MapView) {
                MainFrame.getInstance().getRightPanel().misKliknut(e.getX(), e.getY(), ((MapView) e.getSource()).getMapa());
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
            }
        }
    }

    public JPanel getRadnaPovrsina() {
        return radnaPovrsina;
    }

    public void setRadnaPovrsina(JPanel radnaPovrsina) {
        this.radnaPovrsina = radnaPovrsina;
    }

    public MindMap getMapa() {
        return mapa;
    }

    public void setMapa(MindMap mapa) {
        this.mapa = mapa;
    }
}
