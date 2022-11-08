package tp.practicas;
import java.util.Arrays;

/**
 * Clase que representa conjuntos
 * como objetos de tipo String y realiza
 * operaciones típicas sobre ellos.
 * 
 * @author Grupo 45-4 TP
 *
 */
public class ConjuntoDeStrings {
	private String[] conjunto;
	
	/**
	 * Constructor que inicializa un conjunto
	 * tomando los valores no repetidos de un array
	 * pasado como parámetro.
	 * @param x
	 */
	public ConjuntoDeStrings(String... x) {
		String[] auxiliar = new String[x.length];
		int count = 0; 	//Contador de elementos válidos del conjunto.
		for (int i = 0; i < x.length; i++) {
			boolean repetido = false;
			for(int j = 0; j < x.length; j++) {
				if(auxiliar[j] != null) {
					if (x[i].equals(auxiliar[j])) { //Tratamos los elementos repetidos.
						repetido = true;
						break;
					}
			    }
			}
			if (repetido == false) { //Copiamos los elementos no repetidos.
				auxiliar[count] = x[i];
				count++;
			}
		}
		String[] res = new String[count]; //Creamos nuevo array con la longitud del contador
		for (int j = 0; j < res.length; j++) {
			res[j] = auxiliar[j];
		}
		this.conjunto = res;
	}
	
	/**
	 * Devuelve el cardinal del conjunto accediendo
	 * a la longitud del array que lo contjene.
	 * @return cardinal del conjunto
	 */
	public int cardinal() {
		return this.conjunto.length;
	}
	
	/**
	 * Comprueba si el conjunto está vacío.
	 * @return true si el conjunto está vacío y false si no lo está
	 */
	public boolean estáVacío() {
		if (this.conjunto.length == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Añade un elemento nuevo si este aún no 
	 * pertenece al conjunto.
	 * @param nuevo elemento a añadir al conjunto
	 * @return true si nuevo se ha añadido, false si nuevo ya pertenecía al conjunto.
	 */
	public boolean añade(String nuevo) {
		if (this.pertenece(nuevo) == false) {
			this.conjunto = Arrays.copyOf(this.conjunto, this.conjunto.length + 1);
			this.conjunto[this.conjunto.length - 1] = nuevo;
			return true;
		}
		return false;
	}
	
	/**
	 * Comprueba que un elemento String pertenece
	 * al conjunto
	 * @param element
	 * @return
	 */
	public boolean pertenece(String element) {
		for(int i=0; i <this.conjunto.length; i++) {
			if (this.conjunto[i].equals(element)) {
				return true;
			}
		}
		return false;
		}
	
	/**
	 * Realiza la operación de unión de conjuntos
	 * @param other conjunto a unir
	 * @return conjunto unión
	 */
	public ConjuntoDeStrings unión(ConjuntoDeStrings other) {
		String[] both = new String[this.conjunto.length + other.conjunto.length];
		//Rellenamos primero los elementos del primer conjunto
		for(int i=0; i <this.conjunto.length; i++) {
			both[i] = this.conjunto[i];
			}
		//Rellenamos los elementos del segundo conjunto
		int count = 0;
		for(int j =this.conjunto.length; j < both.length; j++) {
			both[j] = other.conjunto[count];
			count++;
		}
		//Devolvemos el conjunto resultado de la unión
		ConjuntoDeStrings res = new ConjuntoDeStrings(both);
		return res;
	}
	
	/**
	 * Realiza la operación de intersección de conjuntos
	 * @param other conjunto a operar
	 * @return conjunto intersección
	 */
	public ConjuntoDeStrings intersección(ConjuntoDeStrings other) {
		int count = 0;
		String[] aux = new String[this.conjunto.length];
		int aux_i = 0;
		for (int i = 0; i < this.conjunto.length; i++) {
			for (int j = 0; j < other.conjunto.length; j++) {
				if (this.conjunto[i].equals(other.conjunto[j])) {
				    aux[aux_i] = this.conjunto[i];
				    aux_i++;
				    count++;
				}
			}
		}
		String[] interseccion = new String[count];
		for (int k = 0; k < interseccion.length; k++) {
		    interseccion[k] = aux[k];
		}
		ConjuntoDeStrings res = new ConjuntoDeStrings(interseccion);
		return res;
	}
	
	/**
	 * Realiza la operación de diferencia de conjuntos
	 * @param other conjunto a operar
	 * @return conjunto diferencia
	 */
	public ConjuntoDeStrings diferencia(ConjuntoDeStrings other) {
		String[] aux = new String[this.conjunto.length + other.conjunto.length];
		int count = 0;
		for (int i = 0; i < this.conjunto.length; i++) {
			if(other.pertenece(this.conjunto[i]) == false) {
				aux[count] = this.conjunto[i];
				count++;
			}
		}
		String[] diferencia = new String[count];
		for (int j = 0; j < diferencia.length; j++) {
		    diferencia[j] = aux[j];
		}
		ConjuntoDeStrings res = new ConjuntoDeStrings(diferencia);
		return res;
		
	}
	
	/**
	 * Método que sobreescribe el equals para
	 * comprobar la igualdad entre conjuntos
	 * @param other objeto de la clase Object 
	 * @return resultado de la comparación de conjuntos
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof ConjuntoDeStrings) {
			ConjuntoDeStrings aux = (ConjuntoDeStrings) other;
			for(int i = 0; i < this.conjunto.length; i++) {
			    if (aux.pertenece(this.conjunto[i]) == false) {
			        return false;
			    }
			}
			for(int j = 0; j < aux.conjunto.length; j++) {
			    if (this.pertenece(aux.conjunto[j]) == false) {
			        return false;
			    }
			}
	        return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Comprueba si other está o no contenido en el conjunto
	 * @param other objeto de la clase ConjuntoDeStrings
	 * @return true si other es subconjunto de this, false en caso contrario
	 */
	public boolean contenido(ConjuntoDeStrings other) {
		if (other.conjunto.length > this.conjunto.length) {
			return false;
		} else {
			for (int i = 0; i <this.conjunto.length; i++) {
				if (this.pertenece(other.conjunto[i]) == false) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Devuelve un array con los elementos del conjunto
	 * @return conjunto
	 */
	public String[] elementos() {
		return this.conjunto;
	}
	
}
