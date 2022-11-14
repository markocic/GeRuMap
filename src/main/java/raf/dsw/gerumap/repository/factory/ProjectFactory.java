package raf.dsw.gerumap.repository.factory;

import com.sun.tools.javac.Main;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Project;

public class ProjectFactory extends NodeFactory {
    @Override
    public MapNode createNode() {
        Project child = new Project();
        return child;
    }
}
