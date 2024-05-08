package tokio;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lord of the Rings!");
        System.out.println();

        Elf elf = new Elf("elf", 100, 30);
        Human human = new Human("human", 100, 20);
        Hobbit hobbit = new Hobbit("hobbit", 120, 10);
        Ork ork = new Ork("ork", 150, 20);
        Troll troll = new Troll("troll", 200, 50);

        System.out.println("elf attacks ork");
        elf.attack(elf, ork);
        System.out.println();
        System.out.println(ork.toString());
        System.out.println();

        System.out.println("elf attacks troll");
        elf.attack(elf, troll);
        System.out.println();
        System.out.println(troll.toString());
        System.out.println();

        System.out.println("human attacks troll");
        human.attack(human, troll);
        System.out.println();
        System.out.println(troll.toString());
        System.out.println();

        System.out.println("hobbit attacks troll");
        hobbit.attack(hobbit, troll);
        System.out.println();
        System.out.println(troll.toString());
        System.out.println();

        System.out.println("ork attacks human");
        ork.attack(ork, human);
        System.out.println();
        System.out.println(human.toString());
        System.out.println();

        System.out.println("troll attacks elf");
        troll.attack(troll, elf);
        System.out.println();
        System.out.println(elf.toString());
        System.out.println();

    }
}