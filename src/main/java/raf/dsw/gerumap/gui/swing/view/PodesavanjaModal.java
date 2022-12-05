package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PodesavanjaModal extends JDialog implements ActionListener {

    private String name;
    private Color color;
    private int stroke;
    private boolean confirmed;
    private JTextField nameField;
    private JColorChooser colorChooser;
    private JTextField strokeField;

    public PodesavanjaModal(JFrame parent, String name, Color color, int stroke) {
        super(parent, "Settings", true);
        confirmed = false;
        if (parent != null) {
            Dimension parentSize = parent.getSize();
            Point p = parent.getLocation();
            setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
            setSize(parentSize.width / 4, parentSize.height / 4);
        }
        JPanel messagePane = new JPanel();
        messagePane.add(new JLabel("Ime: "));
        this.nameField = new JTextField(name, 12);
        messagePane.add(nameField);

        this.colorChooser = new JColorChooser(color);
        messagePane.add(colorChooser);

        messagePane.add(new JLabel("Stroke: "));
        this.strokeField = new JTextField(Integer.toString(stroke), 12);
        messagePane.add(strokeField);

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
        confirmed = false;
        setVisible(false);
        dispose();
    }

    public void saveActionPerformed(ActionEvent e) {
        // kod za save dugme
        confirmed = true;
        this.name = nameField.getText();
        this.color = colorChooser.getColor();
        this.stroke = Integer.parseInt(strokeField.getText());
        setVisible(false);
        dispose();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getStroke() {
        return stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
