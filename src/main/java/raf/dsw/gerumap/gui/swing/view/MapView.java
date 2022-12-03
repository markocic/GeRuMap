package raf.dsw.gerumap.gui.swing.view;

import com.sun.tools.javac.Main;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.state.concrete.DodajPojamState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MapView extends JInternalFrame{

    //List<Painter> painters;
    private JPanel radnaPovrsina;



    public MapView() {
        super(" ",true,true,true,true);
        //this.setBackground(Color.lightGray); // trenutno postavljeno radi razlikovanja
        this.addMouseListener(new MouseController());
        setIconifiable(true);
        setClosable(true);
        setSize(400,400);
        setVisible(true);
        this.setDefaultCloseOperation(2);

    }

    public class MouseController extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (MainFrame.getInstance().getRightPanel().getStateManager().getCurrentState() instanceof DodajPojamState) {
                    // trenutni state je dodaj pojam
                    MainFrame.getInstance().getRightPanel().getStateManager().getCurrentState().performAction();
                }
                System.out.println("pritisnut levi klik na mestu " + e.getX() + " " + e.getY());
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                System.out.println("otpusten levi klik na mestu " + e.getX() + " " + e.getY());
            }
        }
    }

}
