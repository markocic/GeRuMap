package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.state.State;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class DodajPojamState extends State {
    @Override
    public void mousePressedState(int x, int y, MindMap map) {
        System.out.println("dodaj pojam state, implementirati crtanje ovde");
        // pravljenje novog objekta instance Element i povezivanje sa mapom
        Enumeration<TreeNode> children = ((MapTree)MainFrame.getInstance().getMapTree()).getOpenedNode().children();
        MapTreeItem childMap = null;
        while(children.hasMoreElements()) {
            childMap = (MapTreeItem) children.nextElement();
            if (childMap.getMapNode().getName().equals(map.getName())) {
                // nasli smo mapu, dodajemo joj dete
                MainFrame.getInstance().getMapTree().addChild(childMap);
                return;
            }
        }

        // TODO: sada treba nacrtati novi element, pre toga pitati za naziv u oblacicu, mozemo proslediti taj naziv elementu tako da ime bude odmah postavljeno
    }
}
