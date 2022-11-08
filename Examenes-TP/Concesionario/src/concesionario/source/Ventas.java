package concesionario.source;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Ventas {
    private List<Vendible> sales = new ArrayList<>();

    public void añadeVenta(Vendible sale) {
        this.sales.add(sale);
    }

    public int totalVentas() {
        int totalSalesPVP = 0;

        for(Vendible i : this.sales) {
            totalSalesPVP += i.damePVP();
        }
        return totalSalesPVP;
    }

    public List<Vendible> listaVentas() {
        List<Vendible> copyOfSales = new ArrayList<>(this.sales);
        return copyOfSales;
    }

    // TODO:
    public String masVendido() {
        if(this.sales.size() == 0) {
            return null;
        } else {
            for(Vendible i : this.sales) {
                if(i.dameId().equals())
            }
        }
    }

    @Override
    public String toString() {
        String format = "";

        for(int i = 0; i < this.sales.size(); i++) {
            format += i + ". "; // i+1
        }
        return format + this.sales.stream().map(Vendible::toString)
                .collect(Collectors.joining("\n"));
    }
}