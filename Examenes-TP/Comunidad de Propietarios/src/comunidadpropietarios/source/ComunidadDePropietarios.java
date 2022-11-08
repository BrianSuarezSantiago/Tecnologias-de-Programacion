package comunidadpropietarios.source;

import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ComunidadDePropietarios extends Propietario {
    private double annualCommunityBudget;
    private Set<Propietario> ownersCommunity = new TreeSet<>();

    public ComunidadDePropietarios(String nameOwnersCommunity, double annualCommunityBudget) {
        super(nameOwnersCommunity);
        this.annualCommunityBudget = annualCommunityBudget;
    }

    public void addPropietario(Propietario owner) {
        for(Propietario i : this.ownersCommunity) {
            if(i.getNombre().equalsIgnoreCase(owner.getNombre())) {
                this.ownersCommunity.add(owner);
            }
        }
        this.ownersCommunity.add(owner);
    }

    public void removePropietario(String ownerName) {
        this.ownersCommunity.removeIf(i -> i.getNombre().equalsIgnoreCase(ownerName));
    }

    public double cuotaMensual(Propietario owner) {
        double totalAmount = 0.0;
        //totalAmount = (owner.cuotaTotal() * this.annualCommunityBudget)/100;
        for(Propietario i : this.ownersCommunity) {
            if(i.getNombre().equalsIgnoreCase(owner.getNombre())) {
                totalAmount = (i.cuotaTotal() * this.annualCommunityBudget)/100;
            }
        }
        return totalAmount/12;
    }

    public Propietario getPropietario(String ownerName) {
        //  TODO: return this.community.stream().filter(i -> i.getNombre().equalsIgnoreCase(ownerName)).collect(); devolver un objeto de este tipo en vez de list

        for(Propietario i : this.ownersCommunity) {
            if(i.getNombre().equalsIgnoreCase(ownerName)) {
                return i;
            }
        }
        return null;
    }

    // TODO:
    public List<String> getFincasDistintas() {
        List<String> differentProperties = new ArrayList<>();

        for(Propietario i : this.ownersCommunity) {
            differentProperties.add(i.getFincas() + ":" +
                    this.ownersCommunity.stream().filter(x -> x.getType().equals(i.getType())).count());
        }
        return differentProperties;
    }

    @Override
    public String toString() {
        /*
        List<Propietario> sortedOwners = new ArrayList<>(this.ownersCommunity);
        Collections.sort(a, new Comparator<Propietario>() {

            @Override
            public int compare(Propietario o1, Propietario o2) {
                return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            }
        });
        return sortedOwners.stream().collect(Collector.joining("\n"));
        */

        return this.ownersCommunity.stream().map(Propietario::getNombre).collect(Collectors.joining("\n"));
    }
}