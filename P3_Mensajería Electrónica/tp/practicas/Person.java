package tp.practicas;

/**
 * Subclase heredada de la superclase Contact que se emplea para representar contactos.
 * Las personas tienen, además, un número de teléfono representado por una ristra.
 *
 * @author Grupo 45-4 Tecnologías de Programación
 * @version 1.0.0
 */
public class Person extends Contact {
    private final String telephoneNumber;

    /**
     * Constructor al que se le pasan dos parámetros, el nombre de la persona
     * (String) y el número de teléfono (String) e inicializa ambos parámetros.
     *
     * @param namePerson Representa el nombre de la persona.
     * @param telephoneNumber Representa el número de teléfono.
     */
    public Person(String namePerson, String telephoneNumber) {
        super(namePerson);
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Método que devuelve una ristra con la concatenación del nombre seguido de
     * dos puntos y un espacio (": ") y seguido del número de teléfono.
     *
     * @return String con el formato descrito anteriormente.
     */
    @Override
    public String toString() {
        return this.contactName + ": " + this.telephoneNumber;
    }

    /**
     * Método que envía un SMS a un contacto en base al número de teléfono especificado.
     *
     * @param messageToSend Representa el mensaje a enviar.
     */
    @Override
    public void sendSMS(String messageToSend) {
        SMSTools.sendMessage(this.telephoneNumber, messageToSend);
    }
}
