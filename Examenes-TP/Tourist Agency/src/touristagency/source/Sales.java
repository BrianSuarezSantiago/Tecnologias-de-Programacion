package touristagency.source;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sales {
    private List<Sale> sales = new ArrayList<>();

    public void add(Sale sale) {
        this.sales.add(sale);
    }

    public void remove(int position) {
        this.sales.remove(position);    // Removes the element at the specified position in this list
        //this.sales.remove(this.sales.get(position));
    }

    public double totalSales(String saleName) {
        double amount = 0.0;

        for(Sale i : this.sales) {
            if(i.getName().equalsIgnoreCase(saleName)) {
                amount += i.getPrice();
            }
        }
        return amount;
    }

    public List<Sale> salesOrderByPrice(int maximumOfSalesToReturn) {
        List<Sale> sortedSales = new ArrayList<>();

        for(int i = 0; i < this.sales.size(); i++) {
            if(i < maximumOfSalesToReturn) {
                sortedSales.add(this.sales.get(i));
            }
        }
        Collections.sort(sortedSales, new Comparator<Sale>() {

            @Override
            public int compare(Sale sale1, Sale sale2) {
                if(sale1.getPrice() == sale2.getPrice()) {
                    return sale1.getName().compareToIgnoreCase(sale2.getName());
                } else {
                    return (int) (sale2.getPrice() - sale1.getPrice());
                }
            }
        });
        return sortedSales;
    }

    public List<Sale> getAllSales() {
        List<Sale> copyOfSales = new ArrayList<>(this.sales);
        return copyOfSales;
        //return new ArrayList<>(this.sales);
    }
}