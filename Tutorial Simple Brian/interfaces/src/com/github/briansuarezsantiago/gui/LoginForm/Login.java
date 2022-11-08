package com.github.briansuarezsantiago.gui.LoginForm;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Login extends JFrame {

    public Login() {
        super("Login Form");
        setLayout(new GridLayout(2, 2));

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");

        // File menu items
        JMenuItem openProjectMenu = new JMenuItem("Open Project");
        JMenuItem closeProjectMenu = new JMenuItem("Close Project");
        JMenuItem restartProjectMenu = new JMenuItem("Restart Project");

        // Edit menu items
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");

        // View menu items
        JMenuItem show1MenuItem = new JMenuItem("Show 1");
        JMenuItem show2MenuItem = new JMenuItem("Show 2");
        JMenuItem show3MenuItem = new JMenuItem("Show 3");

        // Add menu items to the file menu
        fileMenu.add(openProjectMenu);
        fileMenu.add(closeProjectMenu);
        fileMenu.add(restartProjectMenu);

        // Add menu items to the edit menu
        editMenu.add(copyMenuItem);
        editMenu.add(cutMenuItem);
        editMenu.add(pasteMenuItem);

        // Add menu items to the view menu
        viewMenu.add(show1MenuItem);
        viewMenu.add(show2MenuItem);
        viewMenu.add(show3MenuItem);

        // Add different menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);

        //add(menuBar);
        setJMenuBar(menuBar);

        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");

        JTextField usernameTextField = new JTextField(10);
        JTextField passwordTextField = new JTextField(10);

        add(usernameLabel);
        add(usernameTextField);
        add(passwordLabel);
        add(passwordTextField);

        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
