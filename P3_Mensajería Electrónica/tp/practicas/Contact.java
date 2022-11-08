package tp.practicas;

/**
 * Clase abstracta para representar contactos. Los contactos pueden ser
 * personas o grupos. Todos los contactos tienen un nombre, representado
 * por una ristra, y un identificador único, representado por un entero.
 *
 * @author Grupo 45-4 Tecnologías de Programación
 * @version 1.0.0
 */
public abstract class Contact {
    protected final String contactName;
    private final int contactID;

    public Contact(String contactName) {
        this.contactName = contactName;
        this.contactID = SMSTools.getUniqueId();
    }

    /**
     * Método que devuelve el identificador del contacto.
     *
     * @return contactID Representa el identificador del contacto.
     */
    public int getId() {
        return this.contactID;
    }

    /**
     * Método que devuelve el nombre del contacto.
     *
     * @return contactName Representa el nombre del contacto.
     */
    public String getName() {
        return this.contactName;
    }

    /**
     * Método que envía un SMS a un contacto, y no devuelve nada.
     *
     * @param messageToSend Representa el mensaje a enviar.
     */
    public abstract void sendSMS(String messageToSend);
}
