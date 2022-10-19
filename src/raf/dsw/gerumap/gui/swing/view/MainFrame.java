package raf.dsw.gerumap.gui.swing.view;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame{
    private static MainFrame instance = null;

    private MainFrame() {
        initialize();
    }

    private void initialize(){
        JPanel panel = new JPanel();
        this.add(panel);
        panel.setBackground(Color.BLUE);


        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("GeRuMap");
        this.setVisible(true);
        
    }

    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
        }
        return instance;

    }
}
