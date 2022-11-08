package com.github.briansuarezsantiago.gui.SimpleFrameWithTextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class Frame extends JFrame {

    public Frame() {
        super("TextField App");
        setLayout(new FlowLayout());

        JLabel passwordLabel = new JLabel("Password: ");
        JTextField passwordTextField = new JTextField(10);

        add(passwordLabel);
        add(passwordTextField);

        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
