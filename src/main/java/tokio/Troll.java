package tokio;

public class Troll extends Beast {

    public Troll(String name, int hp, int resistance) {
        super(name, hp, resistance);
    }

    @Override
    int evaluate(int resistance, Hero enemy) {
        return resistance;
    }
}
