package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorModal extends JDialog implements ActionListener {

    JTextField authorField;

    public AuthorModal(JFrame parent) {
        super(parent, "Author", true);
        if (parent != null) {
            Dimension parentSize = parent.getSize();
            Point p = parent.getLocation();
            setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
            setSize(parentSize.width / 4, parentSize.height / 4);
        }
        JPanel messagePane = new JPanel();
        messagePane.add(new JLabel("Author: "));
        this.authorField = new JTextField(12);
        messagePane.add(authorField);
        getContentPane().add(messagePane);
        JPanel buttonPane = new JPanel();
        JButton buttonSave = new JButton("Save");
        JButton buttonCancel = new JButton("Cancel");
        buttonPane.add(buttonSave);
        buttonPane.add(buttonCancel);
        buttonSave.addActionListener(this::saveActionPerformed);
        buttonCancel.addActionListener(this);
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // kod za cancel dugme, ne radi nista samo gasi modal
        setVisible(false);
        dispose();
    }

    public void saveActionPerformed(ActionEvent e) {
        // kod za save dugme
        if (!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project currentProject)) return;
        currentProject.setAuthor(this.authorField.getText());
        setVisible(false);
        dispose();
    }
}
