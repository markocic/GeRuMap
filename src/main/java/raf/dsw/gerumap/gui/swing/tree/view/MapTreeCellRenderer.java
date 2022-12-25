package raf.dsw.gerumap.gui.swing.tree.view;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class MapTreeCellRenderer extends DefaultTreeCellRenderer {

    public MapTreeCellRenderer() {
    }

    public Component getTreeCellRendererComponent(JTree tree, Object val, boolean sel, boolean expanded,
                                                  boolean list, int row, boolean hasfocus){
        super.getTreeCellRendererComponent(tree,val,sel,expanded,list,row,hasfocus);
        URL imageURL = null;

        if(((MapTreeItem)val).getMapNode() instanceof ProjectExplorer){
            imageURL = getClass().getResource("/images/projectExplorer.png");
        }
        else if(((MapTreeItem)val).getMapNode()instanceof Project){
            imageURL = getClass().getResource("/images/projekat.png");
        }else if(((MapTreeItem)val).getMapNode()instanceof Element){
            imageURL = getClass().getResource("/images/elementNode.png");
        }else if(((MapTreeItem)val).getMapNode()instanceof MindMap){
            imageURL = getClass().getResource("/images/MindMap.png");
        }

        Icon icon = null;
        if(imageURL != null)
            icon = new ImageIcon(imageURL);
        setIcon(icon);


        return this;
    }
}
