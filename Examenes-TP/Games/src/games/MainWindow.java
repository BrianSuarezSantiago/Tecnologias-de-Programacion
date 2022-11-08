package games;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MainWindow extends JFrame {
    private JButton addGame = new JButton("Añadir juego");
    private JButton platformStatistics = new JButton("Estadísticas plataformas");

    private JTextArea textArea = new JTextArea(20, 20);

    private ButtonGroup group = new ButtonGroup();    // NECESARIO PARA EVITAR QUE UN BOTON ESTE SELECCIONADO Y OTRO NO
    private JRadioButton titleRadioButton = new JRadioButton("Por título", true);
    private JRadioButton ageRadioButton = new JRadioButton("Por edad", false);

    private Border border = BorderFactory.createTitledBorder("Orden");
    private TitledBorder titledBorder = new TitledBorder(border);

    private static RegisteredGames registeredGames = new RegisteredGames();    // OBJETO COMUN

    public MainWindow() {
        setTitle("Registro de juegos");
        setLayout(new BorderLayout());


        Container buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
        buttonsPanel.add(addGame);
        buttonsPanel.add(platformStatistics);


        Container textAreaPanel = new JPanel();
        textAreaPanel.add(textArea);


        JPanel radioButtonPanel = new JPanel();
        radioButtonPanel.setLayout(new FlowLayout());
        radioButtonPanel.add(titleRadioButton);
        radioButtonPanel.add(ageRadioButton);
        radioButtonPanel.setBorder(titledBorder);
        // Add radio button to the group
        group.add(titleRadioButton);
        group.add(ageRadioButton);


        // Add different panels to the main frame
        getContentPane().add(buttonsPanel, BorderLayout.WEST);
        getContentPane().add(textAreaPanel, BorderLayout.EAST);
        getContentPane().add(radioButtonPanel, BorderLayout.SOUTH);


        // Basic frame properties
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Action listener
        addGame.addActionListener(añadirJuego);
        platformStatistics.addActionListener(getPlatformsStatistics);
        titleRadioButton.addActionListener(actualizarTexto);
        ageRadioButton.addActionListener(actualizarTexto);
    }

    private ActionListener actualizarTexto = (e) -> {
        if(titleRadioButton.isSelected()) {
            registeredGames.setOrder(0);
        } else {
            registeredGames.setOrder(1);
        }
        String format="";

        for(Game i : registeredGames.getList()) {
            format += i.toString() + "\n";
        }
        textArea.setText(format);
    };

    private ActionListener añadirJuego = (e) -> {
        new NewGameDialog(registeredGames);
    };

    private ActionListener getPlatformsStatistics = (e) -> {
        new PlatformsReport(registeredGames);
    };

    public static void main(String[] args) {
        new MainWindow();
    }
}