package tp.practicas;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Subclase heredada de la superclase Contact que se emplea para representar grupos
 * a los cuales se le pueden agregar o eliminar contactos. También es posible obtener
 * una lista de contactos miembros de un grupo.
 *
 * @author Grupo 45-4 Tecnologías de Programación
 * @version 1.0.0
 */
public class Group extends Contact {
    private List<Contact> group = new ArrayList<>();

    /**
     * Constructor al que se le pasa por parámetro el nombre del grupo (String).
     *
     * @param groupName Representa el nombre del grupo.
     */
    public Group(String groupName) {
        super(groupName);
    }

    /**
     * Método al que se le pasa por parámetro un identificador de contacto y devuelve
     * verdadero si está contenido en el grupo (directa, o indirectamente), y falso,
     * si no se encuentra.
     *
     * @param contactID Representa el identificador del contacto.
     * @return boolean
     */
    public boolean isMember(int contactID) {
        for(Contact i : group) {
            if(i.getId() == contactID) {
                return true;
            } else {
                if(i instanceof Group) {
                    Group aux = (Group) i;
                    if(aux.isMember(contactID)) return true;
                    //return aux.isMember(contactID);
                }
            }
        }
        return false;
    }

    /**
     * Método al que se le pasa por parámetro un contacto a añadir y devuelve falso si el
     * contacto a añadir es el propio contacto, o ya está contenido en el grupo, directa o
     * indirectamente (grupo contenido). Si lo ha podido añadir devuelve verdadero.
     *
     * @param contactToAdd Representa el contacto a añadir.
     * @return boolean
     */
    public boolean add(Contact contactToAdd) {
        if(this.getId() == contactToAdd.getId()) return false;   // TODO: this.getId(); ???
        if(this.isMember(contactToAdd.getId())) return false;
        this.group.add(contactToAdd);
        return true;
    }

    /**
     * Método al que se le pasa por parámetro un identificador de contacto y lo elimina del
     * grupo (sólo directamente) y devuelve falso si el contacto no está contenido en el grupo.
     *
     * @param contactID Representa el identificador del contacto.
     * @return boolean
     */
    public boolean remove(int contactID) {
        for(Contact i : group) {
            if(i.getId() == contactID) {
                this.group.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Método que devuelve una lista con los contactos directos del grupo ordenada por el
     * identificador del contacto. Si se modificara la lista devuelta no se deberían modificar
     * los contactos del grupo.
     *
     * @return Lista con los contactos directos contenidos en el grupos ordenados por el identificador del contacto.
     */
    public List<Contact> getContacts() {
        List<Contact> copyOfGroup = new ArrayList<>(this.group);
        Collections.sort(copyOfGroup, new OrderByID());
        return copyOfGroup;
    }

    /**
     * Método que devuelve una ristra con el nombre del grupo seguido de un salto de línea ("\n")
     * y la concatenación de la representación como ristra (toString) de los contactos directos del
     * grupo seguidos por saltos de línea ("\n"), ordenada por el nombre del contacto.
     *
     * @return String con el formato anteriormente especificado.
     */
    @Override
    public String toString() {
        Collections.sort(this.group, new OrderByName());
        String format = this.getName() + "\n";
        for(Contact i : group) {
            if(i instanceof Person) {
                Person person = (Person) i;
                format += person.toString() + "\n";
            } else {
                format += i.toString() + "\n";
            }
        }
        return format;
    }

    /**
     * Método que envía un mensaje pasado como parámetro a cada uno de los contactos contenidos en
     * el grupo.
     *
     * @param messageToSend Representa el mensaje a enviar.
     */

    @Override
    public void sendSMS(String messageToSend) {
        for(Contact i : group) {
            i.sendSMS(messageToSend);
        }
    }

    /**
     * Clase privada que implementa la interfaz Comparator<T> con el objetivo  de ordenar teniendo en
     * cuenta el nombre de los contactos.
     */
    private static class OrderByName implements Comparator<Contact> {

        @Override
        public int compare(Contact contact1, Contact contact2) {
            return contact1.getName().compareToIgnoreCase(contact2.getName());
        }
    }

    /**
     * Clase privada que implementa la interfaz Comparator<T> con el objetivo de ordenar teniendo en
     * cuenta el identificador de los contactos.
     */
    private static class OrderByID implements Comparator<Contact> {

        @Override
        public int compare(Contact contact1, Contact contact2) {
            return contact1.getId() - contact2.getId();
        }
    }
}
