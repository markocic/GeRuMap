package raf.dsw.gerumap.gui.swing.tree.controller;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeCellRenderer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class MapTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object clickedOn = null;
    private JTextField edit = null;
    public MapTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    public Component getTreeCellEditorComponent(JTree tree, Object obj, boolean argument,
                                                boolean argument2, boolean argument3, int broj){
        clickedOn = obj;
        edit = new JTextField(obj.toString());
        edit.addActionListener(this);
        return edit;
    }



    public boolean isCellEditable(EventObject argument){
        if(argument instanceof MouseEvent)
            if(((MouseEvent) argument).getClickCount() == 3){ //caka da nakon 3 klika imamo promijenu
                return true;
            }

        return false;
    }

    public void actionPerformed(ActionEvent e){
        if(!(clickedOn instanceof MapTreeItem))
            return;
        MapTreeItem clicked = (MapTreeItem) clickedOn;
        clicked.setName(e.getActionCommand());
    }

}
