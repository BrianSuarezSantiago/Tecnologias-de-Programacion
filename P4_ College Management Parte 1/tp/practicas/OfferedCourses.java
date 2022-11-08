package tp.practicas;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Clase que representa el conjunto de asignaturas que ofrece un centro educativo.
 *
 * @author Grupo 45-4 Tecnologías de Programación
 * @version 1.0.0
 */
public class OfferedCourses {
    private Set<Course> offeredCourses;
    
    /**
	 * Constructor sin parámetros que inicializa a vacío el 
	 * contenedor de asignaturas ofertadas por el centro educativo.
	 */
    public OfferedCourses() {
        this.offeredCourses = new HashSet<>();
    }
    
    /**
	 * Método que añade una asignatura pasada como parámetro al 
	 * contenedor de asignaturas. Devuelve verdadero si la ha 
	 * añadido, o falso si ya está registrada una asignatura con 
	 * el mismo identificador.
	 * 
	 * @param course Representa la asignatura a añadir.
	 * @return Devuelve verdadero si la ha añadido, o falso si ya 
	 * está registrada una asignatura con el mismo identificador.
	 */
    public boolean addCourse(Course course) {
        for(Course i : offeredCourses) {
            if(i.getCode() == course.getCode()) return false;
        }
        offeredCourses.add(course);
        return true;
    }
    
    /**
	 * Método que elimina la asignatura con el identificador pasado 
	 * por parámetro. Devuelve verdadero si la elimina y falso si no 
	 * se encuentra.
	 * 
	 * @param courseID Representa el identificador de la asignatura.
	 * @return Devuelve verdadero si la elimina y falso si no se encuentra.
	 */
    public boolean removeCourse(int courseID) {
        for(Course i : offeredCourses) {
            if(i.getCode() == courseID) {
                offeredCourses.remove(i);
                return true;
            }
        }
        return false;
    }
    
    /**
	 * Método que devuelve una asignatura a partir de su cñodigo 
	 * identificador. Si no existe devuelve null.
	 * 
	 * @param courseID Representa el identificador de la asignatura.
	 * @return Devuelve una asignatura con el mismo código que el pasado como 
	 * parámetro si existe y null si no existe dicha asignatura.
	 */
    public Course getCourse(int courseID) {
        for(Course i : offeredCourses) {
            if(i.getCode() == courseID) return i;
        }
        return null;
    }
    
    /**
	 * Método que devuelve una lista con las asignaturas que oferta
	 * el centro educativo, ordenadas por el método toString() de la 
	 * asignatura (Course).
	 * 
	 * @return Lista de asignaturas ofertadas por el centro.
	 */
    public List<Course> getCourses() {
        List<Course> copyOfOfferedCourses = new ArrayList<>(offeredCourses);
        Collections.sort(copyOfOfferedCourses, new OrderOfferedCourses());
        return copyOfOfferedCourses;
    }


    
	/**
    * Clase comparadora que implementa la interfaz Comparator<T>
    * Esta clase se emplea para realizar las comparaciones de las 
    * asignaturas <Course> teniendo en cuenta la representación 
    * implementada en el método toString() correspondiente.
    */ 
    private class OrderOfferedCourses implements Comparator<Course> {
        
        /**
         * Método que compara dos asignaturas en función de su método
         * toString() y las ordena ignorando las mayúsculas y minúsculas.
         */ 
        @Override
        public int compare(Course course1, Course course2) {
            return course1.toString().compareToIgnoreCase(course2.toString());
        }
    }
}
