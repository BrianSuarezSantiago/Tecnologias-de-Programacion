package com.github.briansuarezsantiago.gui.ComboBox;

import javax.swing.JFrame;
import javax.swing.JComboBox;

public class Frame extends JFrame {

    public Frame() {
        super("Frame");
        int[] options = {1, 2, 3, 4, 5};
        String[] op = {"Birds, Cat, Dog"};

        JComboBox comboBox = new JComboBox(op);
        for(int i = 0; i < options.length; i++) {
            comboBox.addItem(options[i]);
        }

        // Add combo box to the frame
        add(comboBox);

        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}