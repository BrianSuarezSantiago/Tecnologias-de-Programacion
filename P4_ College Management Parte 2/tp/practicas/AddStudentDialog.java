package tp.practicas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase que inicializa datos para la interfaz gráfica de usuario.
 * 
 * @author Grupo 45-4 Tecnologías de Programación
 * @version 1.0.0
 */
class AddStudentDialog extends JDialog {
    private JTextField nombre;
    private JTextField id;
    private JButton Accept_std;
    private JButton Cancel_std;
    
    public AddStudentDialog(EnrolledStudents enrolledStudents) {
        nombre = new JTextField(10);
        id = new JTextField(12);
        
        Container panel = getContentPane();
        panel.setLayout(new FlowLayout());
        
        panel.add(new JLabel("Student id: "));
        panel.add(id);
        panel.add(new JLabel("Student name: "));
        panel.add(nombre);
        
        JPanel panel_button = new JPanel();
        panel_button.setLayout(new BoxLayout(panel_button, BoxLayout.X_AXIS));
        Accept_std = new JButton("Accept");
        Cancel_std = new JButton("Cancel");
        panel_button.add(Accept_std);
        panel_button.add(Cancel_std);
        
        panel.add(panel_button);
        
        Accept_std.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0 ) {
                if (!id.getText().equals("")&& !nombre.getText().equals("")) {
                    if (enrolledStudents.addStudent(new Student(Integer.parseInt(id.getText()), nombre.getText()))) {
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Student already added!");
                    }
                }
            }
        });
        
        Cancel_std.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}