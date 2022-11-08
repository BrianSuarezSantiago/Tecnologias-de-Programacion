package games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.stream.Collectors;

public class PlatformsReport extends JFrame {
    private JTextArea textArea = new JTextArea(20, 20);

    private JButton acceptButton = new JButton("Aceptar");
    private JButton cancelButton = new JButton("Cancelar");

    private RegisteredGames registeredGames;

    public PlatformsReport(RegisteredGames registeredGames) {
        this.registeredGames = registeredGames;

        setTitle("Estadísticas de plataformas");
        setLayout(new BorderLayout());


        Container buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(acceptButton);
        buttonsPanel.add(cancelButton);

        getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
        getContentPane().add(textArea, BorderLayout.EAST);


        // Basic frame properties
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Action listeners for PlatformsReport
        acceptButton.addActionListener(platformsStatistics);
        cancelButton.addActionListener(cancel);
    }

    private ActionListener platformsStatistics = (e) -> {
        String format = registeredGames.getListPlatforms().stream().collect(Collectors.joining(", ", "[", "]"));
        textArea.setText(format);
    };

    private ActionListener cancel = (e) -> {
        dispose();
    };
}