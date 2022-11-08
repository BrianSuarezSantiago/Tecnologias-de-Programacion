package com.github.briansuarezsantiago.gui.ComplexMenuBar;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuBar extends JFrame {

    public MenuBar() {
        super("Complex MenuBar");

        // Creates menu bar as a container for all the menus
        JMenuBar menuBar = new JMenuBar();

        // Creates different menu
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");

        // Creates different menu items for the file menu
        JMenuItem openProjectMenuItem = new JMenuItem("Open Project");
        JMenuItem closeProjectMenuItem = new JMenuItem("Close Project");
        JMenuItem runProjectMenuItem = new JMenuItem("Run Project");

        // Creates different menu items for the edit menu
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        JMenuItem pasteMenuItem = new JMenuItem("Close");

        // Creates different menu items for the view menu
        JMenuItem showMenuItem1 = new JMenuItem("Show 1");
        JMenuItem showMenuItem2 = new JMenuItem("Show 2");
        JMenuItem showMenuItem3 = new JMenuItem("Show 3");

        // Add different menu items to the menu
        fileMenu.add(openProjectMenuItem);
        fileMenu.add(closeProjectMenuItem);
        fileMenu.add(runProjectMenuItem);

        editMenu.add(copyMenuItem);
        editMenu.add(cutMenuItem);
        editMenu.add(pasteMenuItem);

        viewMenu.add(showMenuItem1);
        viewMenu.add(showMenuItem2);
        viewMenu.add(showMenuItem3);

        // Add different menus to the menu bar container
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);

        // Add menu bar to the frame
        add(menuBar);

        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
