package com.github.briansuarezsantiago.gui.SimpleFrameWithButton;

import javax.swing.JFrame;
import javax.swing.JButton;

public class SimpleFrame extends JFrame {

    public SimpleFrame() {
        super("Simple Frame with Button");

        JButton button = new JButton("Hit me!!");
        // Tambien funciona solo con add(button) --> Esto se debe a que getContentPane() solo te devuelve el ultimo componente añadido
        getContentPane().add(button);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(100, 80);
    }
}
