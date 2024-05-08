package tokio;

abstract class Character {
    private String name;
    private int hp;
    private int resistance;

    public Character(String name, int hp, int resistance) {
        this.name = name;
        this.hp = hp;
        this.resistance = resistance;
    }

    abstract int attack(Character attacker, Character defensor);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", resistance=" + resistance +
                '}';
    }
}
