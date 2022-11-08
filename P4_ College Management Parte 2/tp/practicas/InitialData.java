package tp.practicas;

/**
 * Clase que inicializa datos para la interfaz gráfica de usuario.
 * 
 * @author Grupo 45-4 Tecnologías de Programación
 * @version 1.0.0
 */
public class InitialData {

    static void init(OfferedCourses offeredCourses, EnrolledStudents enrolledStudents) {
        // Inicialización de las asignaturas ofertadas por el centro educativo
        offeredCourses.addCourse(new Course(100, "Mathematic"));
        offeredCourses.addCourse(new Course(101, "Language"));
        offeredCourses.addCourse(new Course(102, "History"));
        offeredCourses.addCourse(new Course(103, "Geography"));
        offeredCourses.addCourse(new Course(104, "Physics"));
        offeredCourses.addCourse(new Course(108, "Biology"));
        offeredCourses.addCourse(new Course(110, "Chemistry"));
        offeredCourses.addCourse(new Course(111, "Earth Science"));
        
        // Inicialización de los estudiantes matriculados en el centro educativo
        Student s1 = new Student(4,"Fulano");
        s1.enrollCourse(offeredCourses.getCourse(100));
        s1.enrollCourse(offeredCourses.getCourse(101));
        enrolledStudents.addStudent(s1);

        Student s2 = new Student(2,"Mengano");
        s2.enrollCourse(offeredCourses.getCourse(101));
        s2.enrollCourse(offeredCourses.getCourse(103));
        enrolledStudents.addStudent(s2);
        enrolledStudents.addStudent(new Student(3,"Zutano"));
    }
}