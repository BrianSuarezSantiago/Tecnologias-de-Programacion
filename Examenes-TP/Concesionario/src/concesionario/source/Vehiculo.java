package concesionario.source;

import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Vehiculo extends Extra {
    // TODO: si heredamos de una clase que implementa una interfaz, la subclase tambien la implementa ?
    private Set<Extra> extras = new HashSet<>();

    public Vehiculo(String vehicleId, String vehicleModel, int vehiclePVP) {
        super(vehicleId, vehicleModel, vehiclePVP);
    }

    @Override
    public int damePVP() {
        int amountExtras = 0;

        for(Extra i : this.extras) {
            amountExtras += i.damePVP();
        }
        return super.damePVP() + amountExtras;
    }

    public boolean añadeExtra(Extra extra) {
        for(Extra i : this.extras) {
            if(i.dameId().equalsIgnoreCase(extra.dameId())) {
                return false;
            }
        }
        this.extras.add(extra);
        return true;
    }

    public boolean quitaExtra(Extra extra) {
        return this.extras.removeIf(i -> i.dameId().equalsIgnoreCase(extra.dameId()));
    }
//        for(Extra i : this.extras) {
//            if(i.dameId().equalsIgnoreCase(extra.dameId())) {
//                this.extras.remove(extra);
//                return true;
//            }
//        }
//        return false;

    public boolean estaContenido(Extra extra) {
//        return this.extras.contains(extra);
        if(this.extras.contains(extra)) {
            return true;
        } else {
            return false;
        }
    }

    public Set<Extra> dameExtras() {
        Set<Extra> copyOfExtras = new HashSet<>(this.extras);
        return copyOfExtras.stream().sorted(Comparator.comparing(Extra::damePVP)
                            .reversed()).collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        if(this.extras.size() > 0) {
            // There are extras at the vehicle
            return super.toString() + " " + this.extras.stream().map(Extra::dameNombre)
                                                .collect(Collectors.joining(", ", "(", ")"));
        } else {
            return super.toString();
        }
    }
}