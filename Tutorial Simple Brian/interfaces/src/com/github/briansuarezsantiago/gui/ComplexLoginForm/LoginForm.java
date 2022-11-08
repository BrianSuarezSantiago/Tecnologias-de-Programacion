package com.github.briansuarezsantiago.gui.ComplexLoginForm;

import javax.swing.*;
import java.awt.*;

public class LoginForm {

    public LoginForm() {
        JFrame frame = new JFrame("Login Form");
        frame.setLayout(new GridBagLayout());

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");

        JMenuItem openProjectMenu = new JMenuItem("Open Project");
        JMenuItem closeProjectMenu = new JMenuItem("Close Project");
        JMenuItem restartProjectMenu = new JMenuItem("Restart Project");

        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");

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

        // Add file menu to the menu bar
        menuBar.add(fileMenu);

        // Add edit menu to the menu bar
        menuBar.add(editMenu);

        // Add view menu to the menu bar
        menuBar.add(viewMenu);

        // Add menu bar to the frame
        //frame.add(menuBar); NO ES CORRECTO
        frame.setJMenuBar(menuBar);

        Container buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        JButton acceptButton = new JButton("Accept");
        JButton cancelButton = new JButton("Cancel");

        buttonsPanel.add(acceptButton);
        buttonsPanel.add(cancelButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        frame.getContentPane().add(buttonsPanel, gbc);

        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JTextField usernameField = new JTextField(10);
        JTextField passwordField = new JTextField(10);

        Container loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(2, 2));

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);

        frame.add(loginPanel);

        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
