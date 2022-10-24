package raf.dsw.gerumap.gui.swing.view;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame{
    private static MainFrame instance = null;
    MyMenuBar menuBar;
    Toolbar toolbar;


    private MainFrame() {
        initialize();
    }

    private void initialize(){
        initGui();

    }

    private void initGui() {
        Toolkit alat = Toolkit.getDefaultToolkit();
        Dimension screen = alat.getScreenSize();
        int scH = screen.height;
        int scW = screen.width;

        this.setSize(scW/2,scH/2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap");

        menuBar = new MyMenuBar();
        this.setJMenuBar(menuBar);

        toolbar = new Toolbar();
        this.add(toolbar,BorderLayout.NORTH);

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel, panel2);

        panel.setMinimumSize(new Dimension(100,scW/2));
        splitPane.setDividerLocation(scW / 10);





        this.add(splitPane);
        this.setVisible(true);

    }

    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
        }
        return instance;

    }
}
