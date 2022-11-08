package com.github.briansuarezsantiago.gui.SimpleLocalFrame;

import javax.swing.JFrame;

public class SimpleFrame {

    public SimpleFrame() {
        JFrame frame = new JFrame("Simple Local Frame");

        /*
        La principal diferencia de usar un frame heredando directamente de la clase en vez de
        implementarlo localmente, es que localmente tenemos que referenciar los metodos que queremos
        usar, es decir, en vez de usar setVisible(true) hay que usar frame.setVisible(true) para que
        haga referencia al objeto en cuestion.
         */
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 50);
    }
}
