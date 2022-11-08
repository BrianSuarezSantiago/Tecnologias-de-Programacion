package com.github.briansuarezsantiago.gui.CheckBox;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;

public class CheckBox extends JFrame {

    public CheckBox() {
        super("Simple CheckBox");
        setLayout(new FlowLayout());

        JCheckBox option1 = new JCheckBox("Option 1.");
        JCheckBox option2 = new JCheckBox("Option 2.");

        getContentPane().add(option1);
        getContentPane().add(option2);

        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
