package touristagency.source;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TouristPackage extends TouristProduct {
    private double touristPackagePrice, touristPackageDiscount;
    private List<TouristProduct> touristPackage = new ArrayList<>();

    public TouristPackage(String touristPackageName, String touristPackageDescription) {
        super(touristPackageName, touristPackageDescription);
    }

    public boolean add(TouristProduct touristProduct) {
        for(TouristProduct i : this.touristPackage) {
            if(i.getName().equalsIgnoreCase(touristProduct.getName())) {
                return false;
            }   // TODO: al incluir una sentencia else falla el metodo
        }
        this.touristPackage.add(touristProduct);
        return true;
    }

    public boolean remove(String touristProductName) {
        for(TouristProduct i : this.touristPackage) {    // for(int i=0; i<this.touristPackage.size();i++) {}
            if(i.getName().equalsIgnoreCase(touristProductName)) {    // if(this.touristPackage.get(i).getName().equals(touristProduct.getName())) {}
                this.touristPackage.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<TouristProduct> getProducts() {
        List<TouristProduct> copyOfTouristPackage = new ArrayList<>(this.touristPackage);
        Collections.sort(copyOfTouristPackage, new Comparator<TouristProduct>() {

            @Override
            public int compare(TouristProduct touristProduct1, TouristProduct touristProduct2) {
                return touristProduct1.getName().compareToIgnoreCase(touristProduct2.getName());
            }
        });
        return copyOfTouristPackage;
    }

    @Override
    public String toString() {
        return this.touristProductName + ": " + this.touristProductDescription +
                getProducts().stream().map(TouristProduct::getName)
                        .collect(Collectors.joining(", ", "[", "]")) + getPriceWithDiscount() + "€";

    //this.touristPackage.stream().map(TouristProduct::getName).collect(Collectors.toList()).toString();
    //this.touristPackage.stream().map(TouristProduct::getName).collect(Collectors.joining(", "));
    }

    public void setDiscount(double discount) {
        this.touristPackageDiscount = discount;
    }

    @Override
    public double getPrice() {
        return this.touristPackagePrice;
    }

    @Override
    public double getPriceWithDiscount() {
        return this.touristPackagePrice - (this.touristPackagePrice * this.touristPackageDiscount);
    }

    @Override
    public double getDiscount() {
        return this.touristPackageDiscount;
    }
}