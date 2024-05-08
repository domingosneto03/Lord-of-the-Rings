package tokio;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lord of the Rings!");
        Hero hero1 = new Hero("hero1", 100, 5);
        Hero hero2 = new Hero("hero2", 100, 2);
        Beast beast = new Beast("beast", 150, 0);
        System.out.println();

        System.out.println("hero attacks beast:");
        hero1.attack(hero1, beast);
        System.out.println();
        System.out.println(beast.toString());
        System.out.println();

        System.out.println("beast attacks hero1");
        beast.attack(beast, hero1);
        System.out.println();
        System.out.println(hero1.toString());
        System.out.println();

        System.out.println("beast attacks hero2");
        beast.attack(beast, hero2);
        System.out.println();
        System.out.println(hero2.toString());
        System.out.println();


    }
}