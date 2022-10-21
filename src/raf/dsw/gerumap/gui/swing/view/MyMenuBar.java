package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar() {
        init();
    }
    JMenuItem file = new JMenuItem("File");

    private void init() {
        this.add(file);
    }


}
