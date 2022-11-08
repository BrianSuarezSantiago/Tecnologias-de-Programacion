import tp.practicas.*;

public class UsaConjunto {
    public static void main (String[] args) {
        String[] prueba1 = {"luna", "sol", "oscuridad"};
        String[] prueba2 = {"luna"};
        ConjuntoDeStrings conjunto1 = new ConjuntoDeStrings(prueba1);
        ConjuntoDeStrings conjunto2 = new ConjuntoDeStrings(prueba2);
        System.out.println(conjunto1.cardinal());
        System.out.println(conjunto2.cardinal());
        System.out.println(conjunto1.pertenece("luna"));
        System.out.println(conjunto2.añade("oscuridad"));
        System.out.println(conjunto1.equals(conjunto2));
        System.out.println(conjunto2.estáVacío());
        String[] elementos = conjunto1.elementos();
        for (int i = 0; i < elementos.length; i++) {
            System.out.println(elementos[i]);
        }
        ConjuntoDeStrings uni = conjunto1.unión(conjunto2);
        System.out.println(uni.cardinal());
        ConjuntoDeStrings inter = conjunto1.intersección(conjunto2);
        System.out.println(inter.cardinal());
        ConjuntoDeStrings difer = conjunto1.diferencia(conjunto2);
        System.out.println(difer.cardinal());
    }
}