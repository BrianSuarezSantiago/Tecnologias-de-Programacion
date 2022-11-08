package comunidadpropietarios.source;

public class Finca implements Comparable<Finca> {
    private final String propertyName, propertyType;
    private final double propertyFee;

    public Finca(String propertyName, String propertyType, double propertyFee) {
        this.propertyName = propertyName;
        this.propertyType = propertyType;
        this.propertyFee = propertyFee;
    }

    public String getNombre() {
        return this.propertyName;
    }

    public String getTipo() {
        return this.propertyType;
    }

    public double getCuota() {
        return this.propertyFee;
    }

    @Override
    public String toString() {
        return "[Name: " + this.propertyName + " Type: " + this.propertyType + " Fee: " + this.propertyFee + "]";
    }

    // TODO: equals() y compareTo()
    @Override
    public int compareTo(Finca nom) {
        if (nom instanceof Finca) {
            Finca finca = (Finca) nom;

            if (this.propertyName.compareTo(finca.getNombre()) > 0) {
                return 1;
            } else if (this.propertyName.compareTo(finca.getNombre()) < 0) {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Finca)) {
            return false;
        } else {
            return ((Finca)obj).getNombre().equalsIgnoreCase(this.propertyName);
        }
    }
}