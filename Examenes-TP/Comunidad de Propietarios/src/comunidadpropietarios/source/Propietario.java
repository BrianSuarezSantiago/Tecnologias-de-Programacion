package comunidadpropietarios.source;

import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class Propietario implements Comparable<Propietario> {
    private final String ownerName;
    private Set<Finca> properties = new TreeSet<>();

    public Propietario(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getNombre() {
        return this.ownerName;
    }

    public void addFinca(Finca property) {
        this.properties.add(property);
    }

    public void removeFinca(String propertyName) {
//        this.properties.removeIf(i -> i.getNombre().equalsIgnoreCase(propertyName));
        for(Finca i : this.properties) {
            if(i.getNombre().equalsIgnoreCase(propertyName)) {
                this.properties.remove(i);
            }
        }
    }

    public List<Finca> getFincas() {
        List<Finca> copyOfProperties = new ArrayList<>(this.properties);
        return copyOfProperties;
//        return new ArrayList<Finca>(this.properties);
    }

    public double cuotaTotal() {
        double amount = 0.0;

        for(Finca i : this.properties) {    // for(int i = 0; i < this.properties.size(); i++)
            amount += i.getCuota();    // amount += this.properties.get(i).getCuota();
        }
        return amount;
    }

    @Override
    public String toString() {
        String format = "";
        int i = 1;

        for(Finca j : this.properties) {
            format += i + ") [Name: " + j.getNombre() + " Type: " + j.getTipo() + " Fee: " + j.getCuota() + "]\n";
            i++;
        }
        return this.ownerName + ":" + cuotaTotal() + "\n" + format;
        // this.properties.stream().map(Finca::toString).collect(Collectors.joining("\n"));
    }

    /*
    @Override
    public String toString() {    // Does not work if the collection is a set
        String format = this.ownerName + ": " + cuotaTotal() + "\n";

        for(int i=0; i < this.properties.size(); i++) {    // The first element of the collection is 0 but we want to print since 1
            format += i+1 + ") " + this.properties.get(i).toString() + "\n";    // Finca.toString() = [Name: X Type: X Fee: X]
        }
        return format;
    }
     */

    // TODO: la signature actual o esta: public int compareTo(Object nom)
    @Override
    public int compareTo(Propietario nom) {

        if (nom instanceof Propietario) {
            Propietario finca = (Propietario) nom;
            if (this.ownerName.compareTo(finca.getNombre()) > 0) {
                return 1;
            } else if (this.ownerName.compareTo(finca.getNombre()) < 0) {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Propietario)) {
            return false;
        } else {
            // TODO: porque se castea si se supone que es una instancia
            return ((Propietario)obj).getNombre().equalsIgnoreCase(this.ownerName);
        }
    }
}