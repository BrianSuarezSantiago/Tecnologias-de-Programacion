package tp.practicas;

import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Clase que representa el conjunto de estudiantes
 * matriculados en el centro educativo.
 * 
 * @author Grupo 45-4 Tecnologías de Programación
 * @version 1.0.0
 */
public class EnrolledStudents {
    private Set<Student> enrolledStudents;
    
    /**
	 * Constructor sin parámetros que inicializa a
	 * vacío el contenedor de alumnos matriculados.
	 */
    public EnrolledStudents() {
        this.enrolledStudents = new HashSet<>();
    }
    
     /**
	 * Método que añade un estudiante al contenedor de alumnos 
	 * registrados. Devuelve verdadero si lo ha añadido, o falso 
	 * si ya está registrado un alumno con el mismo identificador.
	 * 
	 * @param student Representa el estudiante a añadir.
	 * @return Verdadero si ha añadido al estudiante y falso si
	 * se encuentra registrado un alumno con el mismo código 
	 * identificativo.
	 */ 
    public boolean addStudent(Student student) {
        if(enrolledStudents.contains(student)) {
            return false;
        }
        enrolledStudents.add(student);
        return true;
    }
    
    /**
	 * Método que elimina el estudiante con el identificador pasado 
	 * por parámetro. Devuelve verdadero si elimina al estudiante y 
	 * falso si no se encuentra registrado ningún estudiante con
	 * dicho código identificativo.
	 * 
	 * @param studentID Representa el identificador del estudiante.
	 * @return Verdadero si elimina al estudiante y falso si no se 
	 * encuentra registrado ningún estudiante con dicho código 
	 * identificativo.
	 */ 
    public boolean removeStudent(int studentID) {
        for(Student i : enrolledStudents) {
            if(i.getId() == studentID) {
                enrolledStudents.remove(i);
                return true;
            }
        }
        return false;
    }
    
    /**
	 * Método que devuelve un estudiante a partir de su identificador
	 * pasado como parámetro. Si el estudiante no existe devuelve null.
	 * 
	 * @param studentID Representa el identificador del estudiante.
	 * @return Devuelve un estudiante si este existe y null si no existe.
	 */ 
    public Student getStudent(int studentID) {
        for(Student i : enrolledStudents) {
            if(i.getId() != studentID) return i;
        }
        return null;
    }
    
    /**
	 * Método que devuelve una lista de los estudiantes matriculados 
	 * en la asignatura con el código indicado por parámetro, ordenados 
	 * por nombre, y si tienen el mismo nombre, ordenados por su 
	 * código identificador. 
	 * 
	 * @param courseID Representa el identificador del estudiante.
	 * @return Lista de los estudiantes matriculados en la asignatura
	 * con el código identificador pasado por parámetro.
	 */ 
    public List<Student> getStudentsByCourse(int courseID) {
        List<Student> copyOfStudents = new ArrayList<Student>();
        for(Student i : enrolledStudents) {
            for(Course j : i.getEnrolledCourses()) {
                if(j.getCode() == courseID) copyOfStudents.add(i);
            }
        }
        Collections.sort(copyOfStudents, new OrderStudents());
        return copyOfStudents;
        //return Collections.sort(copyOfStudents, new OrderStudents());
    }

     /**
	 * Método que devuelve una lista de los estudiantes del centro 
	 * educativo, ordenados por nombre, y si tienen el mismo nombre, 
	 * ordenados por su identificador.
	 * 
	 * @return Lista de estudiantes matriculados en el centro educativo.
	 */ 
    public List<Student> getStudentsOrderByName() {
        List<Student> copyOfStudents = new ArrayList<>(enrolledStudents);
        Collections.sort(copyOfStudents, new OrderStudents());
        return copyOfStudents;
    }
    
    /**
	 * Método que devuelve una lista de los estudiantes matriculados
	 * en el centro educativo ordenados por su identificador.
	 * 
	 * @return Lista de estudiantes matriculados en el centro educativo
	 * ordenados por su código identificador.
	 */ 
    public List<Student> getStudentsOrderById() {
        List<Student> copyOfStudents = new ArrayList<>(enrolledStudents);
        Collections.sort(copyOfStudents, new OrderStudentsByID());
        return copyOfStudents;
    }

    /**
    * Clase comparadora que implementa la interfaz Comparator<T>
    * Esta clase se emplea para realizar las comparaciones de los 
    * estudiantes <Student> teniendo en cuenta su identificador
    * en caso de que los nombres de los estudiantes a comparar 
    * sean iguales. En caso contrario, se realiza una comparación
    * teniendo en cuenta el nombre de los mismos.
    */ 
    private class OrderStudents implements Comparator<Student> {

        @Override
        public int compare(Student student1, Student student2) {
            if(student1.getName().compareToIgnoreCase(student2.getName()) != 0) {
                return student1.getName().compareToIgnoreCase(student2.getName());
            }
            return student1.getId() - student2.getId();
        }
    }
    
     /**
	 * Clase comparadora que implementa la interfaz Comparator<T>
	 * Esta clase se emplea para realizar las comparaciones de los 
	 * estudiantes <Student> teniendo en cuenta su identificador.
	 */
    private class OrderStudentsByID implements Comparator<Student> {

        @Override
        public int compare(Student student1, Student student2) {
            return student1.getId() - student2.getId();
        }
    }
}
