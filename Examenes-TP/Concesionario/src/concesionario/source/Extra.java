package concesionario.source;

public class Extra implements Vendible {
    private final String extraId, extraName;
    private final int extraPVP;

    public Extra(String extraId, String extraName, int extraPVP) {
        this.extraId = extraId;
        this.extraName = extraName;
        this.extraPVP = extraPVP;
    }

    @Override
    public String toString() {
        return this.extraId + " " + this.extraName + " " + this.extraPVP;
    }

    @Override
    public String dameId() {
        return this.extraId;
    }

    @Override
    public String dameNombre() {
        return this.extraName;
    }

    @Override
    public int damePVP() {
        return this.extraPVP;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Extra)) {
            return false;
        } else {
            return ((Extra)obj).dameId().equalsIgnoreCase(this.extraId);
        }
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        return PRIME * this.extraId.hashCode();
    }
}