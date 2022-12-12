package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.state.State;

import java.awt.event.MouseWheelEvent;

public class ZumiranjeState  extends State{

    private  double zoomFaktor = 1;
    private  double prevZoomFaktor = 1;
    private double xOff = 0;
    private double yOff = 0;
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() > 0) {
            zoomFaktor = 1;
            zoomFaktor /=1.01;
            System.out.println("ZOOM OUT");
        }
        if(e.getWheelRotation() < 0){
            zoomFaktor = 1;
            zoomFaktor *= 1.01;
            System.out.println("ZOOM IN");
        }

        MapView map = (MapView) e.getSource();
        double xRel = e.getX();
        double yRel = e.getY();
        double zoomDiv = zoomFaktor / prevZoomFaktor;
        //xOff = (zoomDiv) * (xOff) + (1 - zoomDiv) * xRel;
        yOff = (zoomDiv) * (yOff);
        xOff = (zoomDiv) * (xOff);

        map.getTransform().translate(xOff, yOff);
        map.getTransform().scale(zoomFaktor, zoomFaktor);
        prevZoomFaktor = zoomFaktor;
        map.repaint();
    }
}
