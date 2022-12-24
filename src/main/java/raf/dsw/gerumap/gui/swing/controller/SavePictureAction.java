package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class SavePictureAction extends AbstractGerumapAction{

    public SavePictureAction() {
        putValue(SMALL_ICON, loadIcon("/images/picture.png"));
        putValue(NAME, "Save as image");
        putValue(SHORT_DESCRIPTION, "Save the current map as an image");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapView mapView = MainFrame.getInstance().getRightPanel().getCurrentMapView();
        //Jfile chooser se ne pali, ali je jpeg savucaca unutar intelliJ-a
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(mapView.getMapa().getName() + ".png"));
        fileChooser.setDialogTitle("Save as Image");
        int result = fileChooser.showSaveDialog(mapView);
        if(result == JFileChooser.APPROVE_OPTION){
            BufferedImage bi = new BufferedImage(mapView.getSize().width, mapView.getSize().height, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            mapView.paint(g);
            g.dispose();
            try {
                ImageIO.write(bi,"png",fileChooser.getSelectedFile());
            }catch (Exception exception) {

            }
        }
    }
}
