package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.state.State;

import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;

public class ZumiranjeState  extends State{

    private  double zoomFaktor = 1;
    private  double prevZoomFaktor = 1;
    private double xOff = 0;
    private double yOff = 0;
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getPreciseWheelRotation() > 0) {
            zoomFaktor = zoomFaktor + 0.01;
            System.out.println(zoomFaktor);
            System.out.println("ZOOM IN");
        }
        else {
            zoomFaktor -= 0.01;
            System.out.println(zoomFaktor);
            System.out.println("ZOOM OUT");
        }

        if (zoomFaktor < 0.01) {
            zoomFaktor = 0.01;
        }

        MapView map = (MapView) e.getSource();

        double width = map.getWidth();
        double height = map.getHeight();

        double zoomWidth = width * zoomFaktor;
        double zoomHeight = height * zoomFaktor;

        double anchorx = (width - zoomWidth) / 2;
        double anchory = (height - zoomHeight) / 2;

        System.out.println(anchorx);
        System.out.println(anchory);
        map.setAnchory(anchory);
        map.setAnchorx(anchorx);

        map.setTransform(new AffineTransform());
        map.getTransform().translate(anchorx, anchory);
        map.getTransform().scale(zoomFaktor, zoomFaktor);
//        map.getTransform().translate(-100, -100);
//        double xRel = e.getX();
//        double yRel = e.getY();
//        double zoomDiv = zoomFaktor / prevZoomFaktor;
//        //xOff = (zoomDiv) * (xOff) + (1 - zoomDiv) * xRel;
//        yOff = (zoomDiv) * (yOff);
//        xOff = (zoomDiv) * (xOff);
//
//        map.getTransform().translate(xOff, yOff);
//        map.getTransform().scale(zoomFaktor, zoomFaktor);
//        prevZoomFaktor = zoomFaktor;
        map.repaint();
    }
}
