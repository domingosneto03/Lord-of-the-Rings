package tokio;

public class Human extends Hero {

    public Human(String name, int hp, int resistance) {
        super(name, hp, resistance);
    }

    @Override
    int evaluate(int attackValue, Beast enemy) {
        return attackValue;
    }
}
