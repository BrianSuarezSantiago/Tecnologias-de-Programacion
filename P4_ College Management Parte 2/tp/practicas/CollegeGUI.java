package tp.practicas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.UIManager.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase que inicializa datos para la interfaz gráfica de usuario.
 * 
 * @author Grupo 45-4 Tecnologías de Programación
 * @version 1.0.0
 */
public class CollegeGUI extends JFrame {
    static private OfferedCourses offeredCourses = new OfferedCourses();
    static private EnrolledStudents enrolledStudents = new EnrolledStudents();;
    
    // Initialize different GUI components
    private JTextArea data;
    private JRadioButton orderName;
    private JRadioButton orderId;
    private JButton addStudent;
    private JButton enrollStudent;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem itemAddStudent, itemEnrollStudent, itemExit;
    
    // Creates menu bar
    private void constructMenu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menu = new JMenu("Menu");
        itemAddStudent = new JMenuItem("Add new student");
        itemEnrollStudent = new JMenuItem("Enroll student in course");
        itemExit = new JMenuItem("Exit");
        menu.add(itemAddStudent);
        menu.add(itemEnrollStudent);
        menu.add(itemExit);
        menuBar.add(menu);
        
        // Disparar el dialogo de añadir un nuevo estudiante cuando se pulsa el boton "Add new student" del item del menu bar
        itemAddStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                AddStudentDialog addStudentEvent = new AddStudentDialog(enrolledStudents);
            }
        });

        // Dispara el dialogo de matricular estudiante desde el item del menu bar
        itemEnrollStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                EnrollStudentDialog enrollStudentEvent = new EnrollStudentDialog(enrolledStudents, offeredCourses);
            }
        });

        // Dispara la salida de la aplicacion desde el item "Exit" del menu bar
        itemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0); // Success exit code
           }
        });

    }
    
    // Creates "list order" components
    private Component constructControls() {
        orderName = new JRadioButton("Order by student's name", true);
        orderId = new JRadioButton("Order by student's id", false);
        ButtonGroup bg = new ButtonGroup();
        bg.add(orderName);
        bg.add(orderId);
        addStudent = new JButton("Add new student");
        enrollStudent = new JButton("Enroll student in course");
        JPanel east = new JPanel();
        east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
        JPanel order = new JPanel();
        order.setLayout(new BoxLayout(order, BoxLayout.PAGE_AXIS));
        order.add(orderName);
        order.add(orderId);
        order.setBorder(BorderFactory.createTitledBorder("List order"));
        east.add(order);
        east.add(addStudent);
        east.add(enrollStudent);

        // Action manager for "Order by student's name" radiobutton
        orderName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String dataText = "";
                List<Student> students = enrolledStudents.getStudentsOrderByName();
                for(Student student:students) {
                    dataText += student.toString() + "\n";
               }
               data.setText(dataText);
            }
        });

        // Action manager for "Order by student's id" radiobutton
        orderId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String dataText = "";
                List<Student> students = enrolledStudents.getStudentsOrderById();
                for(Student student:students) {
                    dataText += student.toString() + "\n";
                }
                data.setText(dataText);
            }
        });

        // Action manager for "Add new student" button
        addStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                AddStudentDialog addStudentEvent = new AddStudentDialog(enrolledStudents);
            }
        });

        // Action manager for "Enroll student in course" button
        enrollStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                EnrollStudentDialog enrollStudentEvent = new EnrollStudentDialog(enrolledStudents, offeredCourses);
            }
        });

        return east;
    }
    
    private Component constructInfo() {
        data = new JTextArea();
        data.setEditable(false);
        
        String dataText = "";
        List<Student> students = enrolledStudents.getStudentsOrderByName();
        for (Student student: students) {
            dataText += student.toString() + "\n";
        }
        data.setText(dataText);
        return new JScrollPane(data);
    }
    
    // Creates main application frame and define the main panel
    public CollegeGUI() {
        super("College Management");
        InitialData.init(offeredCourses, enrolledStudents);
        constructMenu();
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.add(constructInfo(), BorderLayout.CENTER);
        pane.add(constructControls(), BorderLayout.EAST);
        setContentPane(pane);
        setLocation(50,50);
        setSize(700,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    // Invocation to the GUI application
    public static void main (String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {}
        new CollegeGUI();
    }
}
