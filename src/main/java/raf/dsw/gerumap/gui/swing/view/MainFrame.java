package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.core.IMapTree;
import raf.dsw.gerumap.gui.swing.controller.ActionManager;
import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.repository.factory.FactoryUtils;
import raf.dsw.gerumap.repository.factory.NodeFactory;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame{
    private static MainFrame instance = null;
    private ActionManager actionManager;
    private MyMenuBar menuBar;
    private Toolbar toolbar;

    private IMapTree mapTree;
    private MapTreeView mapTreeView;
    private ProjectExplorer projectExplorer;

    private NodeFactory nodeFactory;
    private FactoryUtils factoryUtils;

    private RightPanel rightPanel;

    private Paleta paleta;








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
        this.rightPanel = new RightPanel();


        // pozivanje osnovnih komponenti
        mapTree = new MapTree();
        mapTreeView = mapTree.generateTree(AppCore.getInstance().getMapRepository().getProjectExplorer());

        this.factoryUtils = new FactoryUtils();

        // postavljanje levog panela
        JScrollPane scroll = new JScrollPane(mapTreeView);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, rightPanel);
        this.getContentPane().add(splitPane,BorderLayout.CENTER);
        splitPane.setOneTouchExpandable(true);

        panel.setMinimumSize(new Dimension(100,scW/2));
        splitPane.setDividerLocation(scW / 10);

        paleta = new Paleta();
        this.getContentPane().add(paleta,BorderLayout.EAST);




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

    public void setMenuBar(MyMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public IMapTree getMapTree() {
        return mapTree;
    }

    public void setMapTree(IMapTree mapTree) {
        this.mapTree = mapTree;
    }

    public MapTreeView getMapTreeView() {
        return mapTreeView;
    }

    public void setMapTreeView(MapTreeView mapTreeView) {
        this.mapTreeView = mapTreeView;
    }

    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    public void setProjectExplorer(ProjectExplorer projectExplorer) {
        this.projectExplorer = projectExplorer;
    }

    public NodeFactory getNodeFactory() {
        return nodeFactory;
    }

    public void setNodeFactory(NodeFactory nodeFactory) {
        this.nodeFactory = nodeFactory;
    }

    public FactoryUtils getFactoryUtils() {
        return factoryUtils;
    }

    public void setFactoryUtils(FactoryUtils factoryUtils) {
        this.factoryUtils = factoryUtils;
    }

    public RightPanel getRightPanel() {
        return rightPanel;
    }

    public void setRightPanel(RightPanel rightPanel) {
        this.rightPanel = rightPanel;
    }

}
