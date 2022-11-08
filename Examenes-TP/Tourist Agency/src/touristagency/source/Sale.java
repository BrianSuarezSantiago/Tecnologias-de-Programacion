package touristagency.source;

public class Sale {
    private final String saleName;
    private final double salePrice;

    public Sale(String saleName, double salePrice) {
        this.saleName = saleName;
        this.salePrice = salePrice;
    }

    public String getName() {
        return this.saleName;
    }

    public double getPrice() {
        return this.salePrice;
    }

    @Override
    public String toString() {
        return this.saleName + ": " + this.salePrice + "€";
    }
}