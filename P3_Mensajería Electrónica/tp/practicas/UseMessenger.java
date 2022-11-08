package tp.practicas;

import tp.practicas.*;

import java.util.List;
import java.util.ArrayList;

public class UseMessenger {

    public static void main (String[] args) {
        Person Brian = new Person("Brian", "012345678");
        Person Enmanuel = new Person("Enmanuel", "123456789");
        Person JoseLuis = new Person("José Luis", "234567891");
        Person Mele = new Person("Mele", "345678910");
        Person Omar = new Person("Omar", "456789127");
        Group Amigos = new Group("Amigos");
        Group IngenieriaInformatica = new Group("Ingeniería Informática");
        Group Trabajos = new Group("Trabajos");
        Group TP = new Group("TP");

        // Test getId() method
        System.out.println("El ID de Brian es: " + Brian.getId());
        System.out.println("El ID de Enmanuel es: " + Enmanuel.getId());
        System.out.println("El ID de José Luis es: " + JoseLuis.getId());
        System.out.println("El ID de Mele es: " + Mele.getId());
        System.out.println("El ID de Omar es: " + Omar.getId());
        System.out.println("-----------------------------------------------");

        // Test add() method
        System.out.println("¿Se añadió Brian al grupo Amigos?: " + Amigos.add(Brian));
        System.out.println("¿Se añadió Enmanuel al grupo Amigos?: " + Amigos.add(Enmanuel));
        System.out.println("¿Se añadió Brian al grupo Brian?: " + Amigos.add(Brian));
        System.out.println("¿Se añadió Omar al grupo Amigos?: " + Amigos.add(Omar));
        System.out.println("¿Se añadió Mele al grupo Amigos?: " + Amigos.add(Mele));
        
        System.out.println("¿Se añadió Omar al grupo Ingeniería Informática?: " + IngenieriaInformatica.add(Omar));
        System.out.println("¿Se añadió Mele al grupo Ingeniería Informática?: " + IngenieriaInformatica.add(Mele));
        System.out.println("-----------------------------------------------");

        // Test isMember() method
        System.out.println("¿Pertenece Brian al grupo Amigos?: " + Amigos.isMember(Brian.getId()));
        System.out.println("¿Pertenece JoseLuis al grupo Amigos?: " + Amigos.isMember(JoseLuis.getId()));
        System.out.println("¿Pertenece Omar al grupo Amigos?: " + Amigos.isMember(Omar.getId()));
        System.out.println("¿Pertenece Mele al grupo Amigos?: " + Amigos.isMember(Mele.getId()));
        System.out.println("-----------------------------------------------");

        // Test remove() method
        System.out.println("¿Se ha eliminado Brian de Amigos?: " + Amigos.remove(Brian.getId()));
        System.out.println("¿Pertenece Brian a Amigos?: " + Amigos.isMember(Brian.getId()));

        System.out.println("¿Se ha eliminado a Enmanuel de Amigos?: " + Amigos.remove(Mele.getId()));
        System.out.println("-----------------------------------------------");

        // Test getContacts() method
        System.out.println("¿Se añadió Omar al grupo Amigos?: " + Amigos.add(Omar));
        System.out.println("¿Se añadió Mele al grupo Amigos?: " + Amigos.add(Mele));

        List<Contact> contactBook = new ArrayList<>();
        contactBook = Amigos.getContacts();
        for (Contact i : contactBook) {
            System.out.println (i.getName() + " -> ID: " + i.getId());
        }
        System.out.println("-----------------------------------------------");

        // Test toString() method
        System.out.print(Amigos.toString());
        System.out.println(IngenieriaInformatica.toString());
    }
}
