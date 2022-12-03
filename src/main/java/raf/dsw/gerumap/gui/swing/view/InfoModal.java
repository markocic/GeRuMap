package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoModal extends JDialog implements ActionListener {



    public InfoModal(JFrame parent) {
        super(parent, "Info", true);
        if (parent != null) {
            Dimension parentSize = parent.getSize();
            Point p = parent.getLocation();
            setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
        }
        JPanel messagePane = new JPanel();
        messagePane.add(new JLabel("Marko Kocic 99/22 RN"));
        JLabel marko = new JLabel(new ImageIcon(InfoModal.class.getResource("/images/marko_100x100.jpeg")));
        messagePane.add(marko);

        messagePane.add(new JLabel("Danilo Joncic 141/22 RN"));
        JLabel danilo = new JLabel(new ImageIcon(InfoModal.class.getResource("/images/danilo_100x100.jpeg")));
        messagePane.add(danilo);

        getContentPane().add(messagePane);
        JPanel buttonPane = new JPanel();
        JButton button = new JButton("OK");
        buttonPane.add(button);
        button.addActionListener(this);
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        dispose();
    }

}
