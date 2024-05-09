package tokio;

public class Elf extends Hero {

    public Elf(String name, int hp, int resistance) {
        super(name, hp, resistance);
    }

    @Override
    int evaluate(int attackValue, Beast enemy) {
        if(enemy instanceof Ork) attackValue += 10; // potência ofensiva aumenta 10 unidades
        return attackValue;
    }
}
