package tokio;

public class Ork extends Beast {

    public Ork(String name, int hp, int resistance) {
        super(name, hp, resistance);
    }

    @Override
    int evaluate(int resistance, Hero enemy) {
        resistance -= 0.10 * resistance; // armadura reduz 10%
        return resistance;
    }
}
