package tp.practicas;

/**
 * Clase que representa una asignatura. La asignatura se caracteriza por
 * estar formada por un número entero que la identifica y por un nombre.
 *
 * @author Grupo 45-4 Tecnologías de Programación
 * @version 1.0.0
 */
public class Course {
    private final int courseID;
    private final String courseName;

    /**
     * Constructor que recibe como parámetros un número entero con el
     * identificador de la asignatura y una String con el nombre de la
     * asignatura.
     *
     * @param courseID Representa el identificador de la asignatura.
     * @param courseName Representa el nombre de la asignatura.
     */
    public Course(int courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
    }

    /**
     * Método que devuelve el identificador de la asignatura.
     *
     * @return Código identificador de la asignatura.
     */
    public int getCode() {
        return this.courseID;
    }

    /**
     * Método que devuelve el nombre de la asignatura.
     *
     * @return Nombre de la asignatura.
     */
    public String getName() {
        return this.courseName;
    }

    /**
     * Método que devuelve una String formada por el identificador de la
     * asignatura entre paréntesis seguido del nombre de la asignatura.
     *
     * @return Identificador de la asignatura entre paréntesis seguido del
     * nombre de la asignatura.
     */
    @Override
    public String toString() {
        return "(" + this.courseID + ")" + this.courseName;
    }
}
