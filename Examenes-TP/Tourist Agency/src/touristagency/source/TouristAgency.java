package touristagency.source;

public class TouristAgency {

    public static void main(String[] args) {
        Flight f1 = new Flight("Iberia 120", "MAD-GAL", 110);
        Flight f2 = new Flight("Ryanair 203", "LPA-MAD", 50);
        Flight f3 = new Flight("Lufthansa 520", "GER-NY", 704);

        Hotel h1 = new Hotel("RIU", "5 STAR HOTEL", 100);
        Hotel h2 = new Hotel("Gloria Palace", "3 STAR HOTEL", 35);
        Hotel h3 = new Hotel("MOTEL BUENA AVENTURA", "SIMPLE MOTEL", 15);

        TouristPackage tp1 = new TouristPackage("Full TP1", "Full Complete Package");
    }
}
