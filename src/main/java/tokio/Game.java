package tokio;

public class Game {
    private int turn;
    private Board board;
    private static final int ACTION_DELAY_MS = 700;

    public Game() {
        this.turn = 1; // jogo começa com a vez dos heróis
        this.board = new Board();
        initGame();
    }

    // grande parte dos valores copiados do enunciado
    private void initGame() {
        // heroes
        Elf legolas = new Elf("Legolas", 150, 30);
        Human aragorn = new Human("Aragorn", 150, 50);
        Human boromir = new Human("Boromir", 100, 60);
        Human gandalf = new Human("Gandalf", 300, 30);
        Hobbit frodo = new Hobbit("Frodo", 20, 10);

        // beasts
        Ork lurtz = new Ork("Lurtz", 200, 60);
        Ork shagrat = new Ork("Shagrat", 220, 50);
        Troll ugluk = new Troll("Uglúk", 120, 30);
        Troll mauhur = new Troll("Mauhúr", 100, 30);

        // placing characters on board
        board.placeIn(legolas);
        board.placeIn(aragorn);
        board.placeIn(boromir);
        board.placeIn(gandalf);
        board.placeIn(frodo);
        board.placeIn(lurtz);
        board.placeIn(shagrat);
        board.placeIn(ugluk);
        board.placeIn(mauhur);
    }

    public void startFight() {
        int position = 0;
        int fightLength = Math.min(board.getHeroList().size(), board.getBeastList().size()); // define as personagens que ficam em lista de espera para lutar
        System.out.println("Turno 1:");
        pause(ACTION_DELAY_MS);
        // partida acaba quando um tipo de personagem for completamente derrotado
        while(!board.getHeroList().isEmpty()  && !board.getBeastList().isEmpty()) {
            var hero = board.getHeroList().get(position);
            var beast = board.getBeastList().get(position);
            System.out.println("\tLuta entre " + hero.getName() + " (Vida=" + hero.getHp() + " Armadura=" + hero.getResistance() + ") e " + beast.getName() + " (Vida=" + beast.getHp() + " Armadura=" + beast.getResistance() + ")");
            pause(ACTION_DELAY_MS);

            int[] heroAttack = hero.attack(beast);
            System.out.println("\t\t" + hero.getName() + " saca " + heroAttack[0] + " e tira " + heroAttack[1] + " de vida a " + beast.getName());
            pause(ACTION_DELAY_MS);
            int[] beastAttack = beast.attack(hero);
            System.out.println("\t\t" + beast.getName() + " saca " + beastAttack[0] + " e tira " + beastAttack[1] + " de vida a " + hero.getName());
            pause(ACTION_DELAY_MS);

            if(isDead(hero)) {
                board.removeDead(hero, position);
                fightLength = Math.min(board.getHeroList().size(), board.getBeastList().size());
            }
            if(isDead(beast)) {
                board.removeDead(beast, position);
                fightLength = Math.min(board.getHeroList().size(), board.getBeastList().size());
            }

            if(fightLength == 0) break;
            else if(position >= fightLength - 1) {
                turn++;
                position = 0;
                for(var x : board.getHeroList()) x.setResistance(x.getOriginalResistance());
                System.out.println("Turno " + turn + ":");
                pause(ACTION_DELAY_MS);
            }
            else position++;
        }
        String winners = board.getBeastList().isEmpty() ? "DOS HEROIS" : "DAS BESTAS";
        System.out.println("VITORIA " + winners + "!!");
    }

    // método que verifica se a personagem morreu
    private boolean isDead(Character character) {
        String race = character.getClass().toString();
        race = race.substring(race.lastIndexOf('.') + 1);
        if(character.getHp() <= 0) {
            System.out.println("\tMorre o " + race + " " + character.getName() + "!");
            pause(ACTION_DELAY_MS);
            return true;
        }
        return false;
    }

    // method to pause the execution for a specified time
    private void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
