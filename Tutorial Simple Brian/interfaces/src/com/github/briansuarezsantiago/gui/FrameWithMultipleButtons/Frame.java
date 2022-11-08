package com.github.briansuarezsantiago.gui.FrameWithMultipleButtons;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        super("Frame with multiple buttons");
        setLayout(new FlowLayout());

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");

        add(button1);
        add(button2);
        add(button3);
        add(button4);

        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
