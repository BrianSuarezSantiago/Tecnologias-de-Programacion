package touristagency.source;

public class Hotel extends TouristProduct {
    private final double hotelPrice;
    private double hotelDiscount;

    public Hotel(String hotelName, String hotelDescription, double hotelPrice) {
        super(hotelName, hotelDescription);
        this.hotelPrice = hotelPrice;
    }

    public void setDiscount(double discount) {
        this.hotelDiscount = discount;
    }

    @Override
    public double getPrice() {
        return this.hotelPrice;
    }

    @Override
    public double getPriceWithDiscount() {
        return this.hotelPrice - (this.hotelPrice * this.hotelDiscount);
        //return this.hotelPrice - (this.hotelPrice * this.hotelDiscount/100);  // TODO: pasan el descuento como porcentaje o como precio a descontar
        //return this.flightPrice - (this.flightPrice * getDiscount());
    }

    @Override
    public double getDiscount() {
        return this.hotelDiscount;
    }
}