package games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewGameDialog extends JFrame {
    private JButton acceptButton = new JButton("Aceptar");
    private JButton cancelButton = new JButton("Cancelar");

    private JTextField titleField = new JTextField(10);
    private JTextField developerField = new JTextField(10);
    private JTextField platformField = new JTextField(10);

    String[] data = {"3", "7", "12", "16", "18"};
    private JComboBox classificationCombo = new JComboBox(data);

    private RegisteredGames registeredGames;    // OBJETO EN COMUN

    public NewGameDialog(RegisteredGames registeredGames) {
        this.registeredGames = registeredGames;

        setTitle("Añadir nuevo juego");
        setLayout(new GridLayout(5, 2));

        Container titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel titleLabel = new JLabel("Título: ");
        titlePanel.add(titleLabel);
        titlePanel.add(titleField);


        Container developerPanel = new JPanel();
        developerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel developerLabel = new JLabel("Desarrollador: ");
        developerPanel.add(developerLabel);
        developerPanel.add(developerField);


        Container platformPanel = new JPanel();
        platformPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel platformLabel = new JLabel("Plataforma: ");
        platformPanel.add(platformLabel);
        platformPanel.add(platformField);


        Container classificationPanel = new JPanel();
        classificationPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//        classificationCombo.addItem("sd"); OTRA FORMA DE AÑADIR ELEMENTOS A UN COMBOBOX
        JLabel classificationLabel = new JLabel("Clasificación: ");
        classificationPanel.add(classificationLabel);
        classificationPanel.add(classificationCombo);


        Container buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(acceptButton);
        buttonsPanel.add(cancelButton);


        // Add components to the main frame
        getContentPane().add(titlePanel);
        getContentPane().add(developerPanel);
        getContentPane().add(platformPanel);
        getContentPane().add(classificationPanel);
        getContentPane().add(buttonsPanel);


        // Basic frame properties
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Components action listener
        cancelButton.addActionListener(cancelFunction);
        acceptButton.addActionListener(acceptFunction);
    }

    private ActionListener cancelFunction = (e) -> {
        dispose();
    };

    private ActionListener acceptFunction = (e) -> {
        Game game = new Game(titleField.getText(), developerField.getText(), platformField.getText(), Integer.parseInt((String) classificationCombo.getSelectedItem()));
        registeredGames.add(game);
        dispose();
    };
}