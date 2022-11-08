package touristagency.source;

public class Flight extends TouristProduct {
    private final double flightPrice;
    private double flightDiscount;

    public Flight(String flightName, String flightDescription, double flightPrice) {
        super(flightName, flightDescription);
        this.flightPrice = flightPrice;
    }

    public void setResident(boolean isResident) {
        if(isResident) {    // if(isResident == true) {}
            this.flightDiscount = 0.75;
        } else {
            this.flightDiscount = 0.0;
        }
    }

    @Override
    public double getPrice() {
        return this.flightPrice;
    }

    @Override
    public double getPriceWithDiscount() {
        return this.flightPrice - (this.flightPrice * this.flightDiscount);
    }

    @Override
    public double getDiscount() {
        return this.flightDiscount;
    }
}