package tp.practicas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Clase que inicializa datos para la interfaz gráfica de usuario.
 * 
 * @author Grupo 45-4 Tecnologías de Programación
 * @version 1.0.0
 */
class EnrollStudentDialog extends JDialog {
    private JComboBox<String> estudiante;
    private JComboBox<String> asignatura;
    private JButton Accept_std;
    private JButton Cancel_std;
    
    public EnrollStudentDialog(EnrolledStudents enrolledStudents, OfferedCourses offeredCourses) {
        estudiante = new JComboBox<String>();
        asignatura = new JComboBox<String>();
        
        List<String> estudiantes = new ArrayList<String>();
        for (Student student: enrolledStudents.getStudentsOrderById()) {
            estudiantes.add(student.getId() + "-" + student.getName());
            estudiante.addItem(student.getId() + "-" + student.getName());
        }
        
        List<String> asignaturas = new ArrayList<String>();
        for (Course course: offeredCourses.getCourses()) {
            asignaturas.add(course.toString());
            asignatura.addItem(course.toString());
        }
        
        Container panel = getContentPane();
        panel.setLayout(new FlowLayout());
        
        panel.add(new JLabel("Student: "));
        panel.add(estudiante);
        panel.add(new JLabel("Course: "));
        panel.add(asignatura);
        
        JPanel panel_button = new JPanel();
        panel_button.setLayout(new BoxLayout(panel_button, BoxLayout.PAGE_AXIS));
        Accept_std = new JButton("Accept");
        Cancel_std = new JButton("Cancel");
        panel_button.add(Accept_std);
        panel_button.add(Cancel_std);
        
        panel.add(panel_button);
        
        // Action manager for accept button
        Accept_std.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0 ){
                Student student = enrolledStudents.getStudentsOrderById().get(estudiante.getSelectedIndex());
                Course course = offeredCourses.getCourses().get(asignatura.getSelectedIndex());
                if (student.enrollCourse(course)) {
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Student already enrolled!");
                }
            }
        });
        
        // Action manager for cancel button
        Cancel_std.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        
        // Set basic properties
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}