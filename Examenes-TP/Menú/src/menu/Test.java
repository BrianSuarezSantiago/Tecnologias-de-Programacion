package menu;

public class Test {

    public static void main(String[] args) {
        Option op1 = new Option("Id1", "Opcion separadora 1");
        Option op2 = new Option("Id2", "Opcion separadora 2");

        Separator sp1 = new Separator("Id 3");
        Separator sp2 = new Separator("Id 4");

        Menu menu1 = new Menu("id 5", "Menu 6");



        System.out.println(menu1.addElement(op2));
        System.out.println(menu1.addElement(op1));
        System.out.println(menu1.addElement(sp1));

        System.out.println(menu1.print(3));
    }
}