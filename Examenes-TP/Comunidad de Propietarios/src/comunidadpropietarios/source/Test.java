package comunidadpropietarios.source;

public class Test {

    public static void main(String[] args) {
        Finca finca1 = new Finca("Finca 1", "Vivienda", 500);
        Finca finca2 = new Finca("Finca 2", "Garage", 20);
        Finca finca3 = new Finca("Finca 3", "Local", 190);
        Finca finca4 = new Finca("Finca 4", "Trastero", 3);

        Propietario propietario = new Propietario("Brian");
//        Propietario propietario2 = new Propietario("Pepe");
//        Propietario propietario3 = new Propietario("Juan");


        propietario.addFinca(finca1);
        propietario.addFinca(finca4);
        propietario.addFinca(finca2);
        propietario.addFinca(finca3);


        ComunidadDePropietarios comunidad = new ComunidadDePropietarios("Mirador de montepinar", 200);

//        comunidad.addPropietario(propietario1);
//        comunidad.addPropietario(propietario2);
//        comunidad.addPropietario(propietario3);
//
//        System.out.println("CUOTA TOTAL");
//        System.out.println(propietario1.cuotaTotal());
//        System.out.println(propietario2.cuotaTotal());
//        System.out.println(propietario3.cuotaTotal());
//
//        System.out.println("CUOTA MENSUAL");
//        System.out.println(comunidad.cuotaMensual(propietario1));
//        System.out.println(comunidad.cuotaMensual(propietario2));
//        System.out.println(comunidad.cuotaMensual(propietario3));


        comunidad.addPropietario(propietario);

        System.out.println("FINCAS DISTINTAS");
        System.out.println(comunidad.getFincasDistintas());



        //TODO: problema a la hora de eliminar varios elementos seguidos no asi con removeIf
//        propietario.removeFinca("FIncA 4");
//        propietario.removeFinca("FIncA 134");
//        propietario.removeFinca("finca 2");
//        propietario.removeFinca("FinCA 3");
//        propietario.removeFinca("FINCA 1");
    }
}