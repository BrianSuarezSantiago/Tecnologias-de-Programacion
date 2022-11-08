package tp.practicas;

import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Clase que representa un estudiante. El estudiante se caracteriza por
 * estar formado por un nombre, un número entero empleado como código
 * identificador y el conjunto de asignaturas en las que se encuentra
 * matriculado.
 *
 * @author Grupo 45-4 Tecnologías de Programación
 * @version 1.0.0
 */
public class Student {
    private final int studentID;
    private final String studentName;
    private Set<Course> setOfCourses = new HashSet<>();

    /**
     * Constructor que recibe como parámetros un número entero con el
     * identificador del estudiante y una String con el nombre.
     *
     * @param studentID   Representa el código identificador del estudiante.
     * @param studentName Representa el nombre del estudiante.
     */
    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    /**
     * Método que devuelve el identificador del estudiante.
     *
     * @return Código identificador del estudiante.
     */
    public int getId() {
        return this.studentID;
    }

    /**
     * Método que devuelve el nombre del estudiante.
     *
     * @return Nombre del estudiante.
     */
    public String getName() {
        return this.studentName;
    }

    /**
     * Método que añade una nueva asignatura pasada por parámetro al
     * conjunto de asignaturas de las que el estudiante está matriculado
     * y devuelve verdadero si la añadeal conjunto de asignaturas de las
     * que se encuentra matriculado el estudiante, o falso si ya se encuentra
     * matriculado en dicha asignatura.
     *
     * @param course Representa la asignatura a añadir.
     * @return Verdadero si añade la asignatura al conjunto de asignaturas en
     * las que el estudiante está matriculado y falso si ya se encuentra
     * matriculado en la asigntaura.
     */
    public boolean enrollCourse(Course course) {
        for(Course i : setOfCourses) {
            if(i.getCode() == course.getCode()) {
                return false;
            }
        }
        setOfCourses.add(course);
        return true;
    }

    /**
     * Método que elimina la asignatura con el código pasado por parámetro de
     * las que el estudiante se encuentra matriculado. Devuelve verdadero si
     * elimina la asignatura y falso si no se encuentra disponible.
     *
     * @param courseID Representa el identificador de la asignatura.
     * @return Verdadero si elimina la asignatura del conjunto de asignaturas
     * en las que se encuentra matriculado el estudiante y falso si la asignatura
     * no se encuentra disponible en el conjunto de asignaturas.
     */
    public boolean unenrollCourse(int courseID) {
        for (Course i : setOfCourses) {
            if (i.getCode() == courseID) {
                setOfCourses.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Método que devuelve una colección con las asignaturas en las que se encuentra
     * matriculado el estudiante, ordenadas por el código identificador de la asignatura.
     *
     * @return Colección con las asignaturas matriculadas por el alumno, ordenadas por
     * el identificador de la asignatura.
     */
    public Collection<Course> getEnrolledCourses() {
        List<Course> copyOfSetOfCourses = new ArrayList<>(setOfCourses);
        Collections.sort(copyOfSetOfCourses, new OrderCourseByID());
        return copyOfSetOfCourses;
    }

    /**
     * Método que devuelve una String formada por el identificador del estudiante seguido
     * de un guión ("-") y del nombre del alumno, seguido de la concatenación de las
     * asignaturas en las que se encuentra matriculado separadas por una coma y un espacio
     * en blanco (", ") entre los caracteres de abre y cierra corchete "["..."]", ordenadas
     * las asignaturas por su código identificativo.
     *
     * @return String con el formato anteriormente especificado.
     */
    @Override
    public String toString() {
        List<Course> copyOfSetOfCourses = new ArrayList<>(setOfCourses);
        Collections.sort(copyOfSetOfCourses, new OrderCourseByID());
        String format = this.studentID + "-" + this.studentName + "[";
        String voidTextToSplit = "";

        for(int i = 0; i < copyOfSetOfCourses.size(); i++) {
            if(i != copyOfSetOfCourses.size() - 1) {
                voidTextToSplit += copyOfSetOfCourses.get(i).toString() + ", ";
            } else {
                voidTextToSplit += copyOfSetOfCourses.get(i).toString();
            }
        }
        return format + voidTextToSplit + "]";
    }



    /**
     * Clase comparadora que implementa la interfaz Comparator<T>.
     * Esta clase se emplea para la realización de comparaciones de
     * las asignaturas <Course> teniendo en cuenta su respectivo
     * cóidgo identificador.
     */
    private static class OrderCourseByID implements Comparator<Course> {
        /**
         * Método que compara entre sí dos argumentos para ordenar.
         *
         * @param course1 Representa el primer objeto para comparar.
         * @param course2 Representa el segundo objeto para comparar.
         * @return Un número entero negativo si el primer argumento es menor que el segundo,
         * 0 si ambos argumentos son iguales o un número entero positivo si el primer argumento
         * es mayor que el segundo.
         */
        @Override
        public int compare(Course course1, Course course2) {
            return course1.getCode() - course2.getCode();
        }
    }

}
