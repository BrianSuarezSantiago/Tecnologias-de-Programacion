package touristagency.source;

public abstract class TouristProduct {
    protected final String touristProductName, touristProductDescription;
    //private double touristProductPrice, touristProductDiscount;

    // TODO: es necesario crear un metodo equals para comparar elementos a la hora de eliminar
    public TouristProduct(String touristProductName, String touristProductDescription) {
        this.touristProductName = touristProductName;
        this.touristProductDescription = touristProductDescription;
    }

    public String getName() {
        return this.touristProductName;
    }

    public String getDescription() {
        return this.touristProductDescription;
    }

    // TODO: seria necesario una implementacion unica en cada una de las subclases
    public abstract double getPrice();

    public abstract double getPriceWithDiscount();

    public abstract double getDiscount();

    @Override
    public String toString() {
        return this.touristProductName + ": " + this.touristProductDescription + " " + getPriceWithDiscount() + "€";
    }
}