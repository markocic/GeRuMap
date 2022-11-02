package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.core.IMapTree;
import raf.dsw.gerumap.gui.swing.controller.ActionManager;
import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame{
    private static MainFrame instance = null;
    private ActionManager actionManager;
    private MyMenuBar menuBar;
    private Toolbar toolbar;

    private IMapTree mapTree;
    private ProjectExplorer projectExplorer;



    private MainFrame() {
    }

    private void initialize(){
        actionManager = new ActionManager();
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

        JScrollPane scroll = new JScrollPane();
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, panel2);
        this.getContentPane().add(splitPane,BorderLayout.CENTER);
        splitPane.setOneTouchExpandable(true);

        panel.setMinimumSize(new Dimension(100,scW/2));
        splitPane.setDividerLocation(scW / 10);

        mapTree = new MapTree();
        mapTree.generateTree(AppCore.getInstance().getMapRepository().getProjectExplorer());



        this.add(splitPane);
        this.setVisible(true);

    }

    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
            instance.initialize();
        }
        return instance;

    }

    public ActionManager getActionManager() {
        return actionManager;
    }
}
