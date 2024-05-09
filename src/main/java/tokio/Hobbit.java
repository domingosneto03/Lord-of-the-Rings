package tokio;

public class Hobbit extends Hero {

    public Hobbit(String name, int hp, int resistance) {
        super(name, hp, resistance);
    }

    @Override
    int evaluate(int attackValue, Beast enemy) {
        if(enemy instanceof Troll) attackValue -= 5; // potência ofensiva diminui 5 unidades
        return attackValue;
    }
}
