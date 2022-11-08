package com.github.briansuarezsantiago.gui.CheckBoxInitialSelected;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;

public class CheckBox extends JFrame {

    public CheckBox() {
        super("CheckBox");
        setLayout(new FlowLayout());

        JCheckBox option1 = new JCheckBox("Option 1.", true);
        JCheckBox option2 = new JCheckBox("Option 2.");
        getContentPane().add(option1);
        getContentPane().add(option2);

        setVisible(true);
        pack();
        setDefaultCloseOperation(3);    // JFrame.EXIT_ON_CLOSE
    }
}
