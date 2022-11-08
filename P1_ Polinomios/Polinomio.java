/**
 * Base class for the representation of Polynomials and that
 * implements functionality to perform various operations on 
 * them.
 *
 * @author Brian Suárez Santiago
 * @version 1.0 2021/10/17
 */
public class Polinomio { 
    private int grado;
    private int[] arrayPolinomio;
    
    /**
     * A default constructor that prepares a Polynomial object 
     * to be used. This polynomial will have degree zero and a 
     * zero independent term.
     */
    public Polinomio() {
        this.grado = 0;
        this.arrayPolinomio = new int[1];
        arrayPolinomio[0] = 0;
    }
    
    /**
     * Constructor to which a vector of integers is passed as a 
     * parameter. The first element of the vector represents the 
     * independent term, the second the coefficient the term of 
     * degree 1 and so on. The degree of the polynomial is the 
     * largest non-zero valued index.
     * 
     * @param vector 
     * @see https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#clone()
     */
    public Polinomio(int[] vector) {
        int[] arrayPolinomio = (int[]) vector.clone();
        this.arrayPolinomio = arrayPolinomio;
        this.grado = grado();
    }
    
    /**
     * Method that returns an integer that represents the degree 
     * of the polynomial.
     * 
     * @return grado It represents the degree of the polynomial.
     */    
    public int grado() {
        int grade = 0;
        if(this.arrayPolinomio.length == 1) {
            grade = 0;
        } else {
            for(int i = (arrayPolinomio.length -1); i != 0; i--)
                if(arrayPolinomio[i] != 0) {
                    grade = i;
                    break;
                }
        }
        return grade;    
    }
    
    /**    
     * Method that is passed a parameter with an integer, i, that 
     * indicates the position of a coefficient of the polynomial 
     * and returns the value of the coefficient, or independent 
     * term, ai. If the integer i does not indicate a valid term it 
     * returns 0.
     * 
     * @param Index representing the position of a coefficient of the polynomial.
     * @return Value of the coefficient, or of the independent term, ai that is 
     * in the position indicated by the parameter index.
     */
    public int coeficiente(int index) {
        if (index<0) {
            return 0;
        } else if(arrayPolinomio.length == 0) {
            return arrayPolinomio[0];
        } else if(index <= arrayPolinomio.length - 1) {
            return this.arrayPolinomio[index];
        } else {
            return 0;
        }
    }
    
    /**    
     * A void method that is passed by parameter an integer, i, 
     * indicating the position of a coefficient of the polynomial 
     * and another integer, v, representing a value. The method 
     * sets the coefficient ai of the polynomial to the value v. 
     * This operation can change the degree of the polynomial.
     * 
     * @param index Integer indicating the position of a coefficient of the polynomial.
     * @param value Value at which the coefficient ai of the polynomial is set.
     */
    public void coeficiente(int index, int value) {
        if(index > arrayPolinomio.length - 1) {
            int[] arrayNuevo = new int[index+1];
            arrayNuevo[index] = value;
            for(int j = 0; j < arrayPolinomio.length; j++) {   
                arrayNuevo[j] = arrayPolinomio[j]; 
            }
            this.arrayPolinomio = arrayNuevo;
            this.grado = grado();
        } else if(index < this.arrayPolinomio.length) {
            this.arrayPolinomio[index] = value; 
        } else {
            int[] arrayNuevo = new int[index];
            arrayNuevo[index] = value;
            for(index = 0; index < this.arrayPolinomio.length; index++) {
                arrayNuevo[index] = this.arrayPolinomio[index];
            }
            this.arrayPolinomio = arrayNuevo;
            this.grado = grado();
        }   
    }
    
    /**    
     * Method that returns a vector of integers, of size degree() + 1, 
     * containing the coefficients of the polynomial from the lowest 
     * degree term to the highest degree term. If the returned vector is
     * modified, the polynomial should not be modified.
     * 
     * @return array Copy of the original integer array that represent the 
     * coefficients of the polynomial.
     */
    public int[] coeficientes() {
    	if(grado() == 0) {
    		int [] array = {arrayPolinomio[0]};
    		return array;
    	} else {
    		int [] array = new int[grado() + 1];
        
        	for(int i = 0; i < grado() + 1; i++) {
        		array[i] = arrayPolinomio[i];
        	}
    		return array;
    	}
    }
    
    /**
     * Redefined method of the Object class, which returns a string 
     * representing the polynomial starting with the highest degree 
     * term and without showing the terms with zero coefficient. In 
     * case all coefficients are zero, toString() must return "0". 
     * 
     * Examples: "0", "3x-2", "4x^5-8x^2+2", "-3x^7".
     * 
     * @return 
     */
    @Override
    public String toString() {
        if(grado ==  0) return "" + arrayPolinomio[0];
        	
        if(grado == 1) {
            String resultado = "";
        	if(arrayPolinomio[1] == 1){resultado += "x";}
        	if(arrayPolinomio[1] == -1){resultado += "-x";}
        	if(arrayPolinomio[1] != 1 && arrayPolinomio[1] != -1){
        		resultado += arrayPolinomio[1] + "x";
        	}
    	    if(arrayPolinomio[0] != 0){
    	    	if(arrayPolinomio[0] > 0) {
    	    	    resultado += "+" + arrayPolinomio[0];
    	    	} else {
    	    	    resultado += arrayPolinomio[0];
    	    	}
    	    }
        	
        return resultado;
        }  
    

    // String for polynomial with grade >= 2
    
    String resultado = "";
    for(int i = grado(); i >= 0; i--) {
        if(arrayPolinomio[i] == 0) {
            continue;
        }
        else if(i == grado()) {
            if(arrayPolinomio[i] == -1) {
                resultado += "-" + arrayPolinomio[i];
            } else {
            	if(arrayPolinomio[i] !=1 ) {
            		resultado += arrayPolinomio[i];
            	}
            }
        } else if (arrayPolinomio[i]  > 0) {
            if(arrayPolinomio[i] == 1 && (i != 0)) {resultado += "+"; }
            else {resultado += "+" + (arrayPolinomio[i]);}
        }
        else if (arrayPolinomio[i]  < 0) {
            if(arrayPolinomio[i] == -1 && i != 0) {resultado += "-"; }
            else {resultado += "-" + (-arrayPolinomio[i]);}
        }
        if (i == 1) {
            resultado += "x";
        } else if (i > 1) {resultado += "x^" + i;}
    }   
    return resultado;
    }
    
    /**    
     * Method that returns a polynomial sum of the current one plus 
     * another one passed by parameter.
     */
    public float valor(float valorReal) {
        if (grado ==  0) return arrayPolinomio[0];
        if (grado ==  1) return (arrayPolinomio[1]*valorReal + arrayPolinomio[0]);
        
        float resultado = 0;
    
        for (int i = arrayPolinomio.length -1; i > 0; i--) {
            if (arrayPolinomio[i] == 0) {
                continue;
            } else {
                resultado += Math.pow(valorReal, i) * arrayPolinomio[i];
            }
        }
        resultado += arrayPolinomio[0];
        return resultado;
    }
    
    /**    
     * Method that returns a polynomial sum of the current one plus 
     * another one passed by parameter.
     */
    public Polinomio suma(Polinomio objeto) {
        Polinomio suma;
        
        if(objeto.arrayPolinomio.length == 0) {
            int [] arraySuma = new int[0];
            arraySuma[0] = arrayPolinomio[0] - objeto.arrayPolinomio[0];
            suma = new Polinomio(arraySuma);
            return suma;
        }
	    int max = 0;
        int min = 0;
    
	    max = Math.max(arrayPolinomio.length, objeto.arrayPolinomio.length);
	    int [] arraySuma = new int[max];
	    
        min = Math.min(arrayPolinomio.length, objeto.arrayPolinomio.length);
        for(int i = 0; i < max; i++) {
            if(i < min) {
                arraySuma[i] = (arrayPolinomio[i] + objeto.arrayPolinomio[i]);
            } else {
                if (arrayPolinomio.length >= objeto.arrayPolinomio.length ) {
                    arraySuma[i] = arrayPolinomio[i];
                } else {
                    arraySuma[i] = objeto.arrayPolinomio[i];
                }
            }
        }
    suma = new Polinomio(arraySuma);
    return suma;
    }
  
    /**    
     * Method that returns a polynomial sum of the current one minus 
     * another one passed by parameter.
     */
    public Polinomio resta(Polinomio objeto) {
        Polinomio resta;
    
        if(objeto.arrayPolinomio.equals(this.arrayPolinomio)) {
        	resta = new Polinomio();
        	return resta;
        }
	    int max = 0;
        int min = 0;
    
	    max = Math.max(arrayPolinomio.length, objeto.arrayPolinomio.length);
	    int [] arrayResta = new int[max];
	    
        min = Math.min(arrayPolinomio.length, objeto.arrayPolinomio.length);
        for(int i = 0; i < max; i++) {
            if(i < min) {
                arrayResta[i] = (arrayPolinomio[i] - objeto.arrayPolinomio[i]);
            } else {
                if (arrayPolinomio.length >= objeto.arrayPolinomio.length ) {
                    arrayResta[i] = arrayPolinomio[i];
                } else {
                    arrayResta[i] = -objeto.arrayPolinomio[i];
                }
            }
        }
    resta = new Polinomio(arrayResta);
    return resta;
    } 
}
