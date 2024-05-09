package tokio;

abstract class Hero extends Character {
    Dice dices = new Dice();
    private int originalResistance;

    public Hero(String name, int hp, int resistance) {
        super(name, hp, resistance);
        originalResistance = resistance;
    }

    @Override
    int[] attack(Character defensor) {
        int[] stats = new int[2];
        int attackValue = dices.throwDice(this, 2);
        attackValue = evaluate(attackValue, (Beast) defensor);
        int damage = attackValue - defensor.getResistance();
        if(damage>0) defensor.setHp(defensor.getHp() - damage);
        else damage = 0;
        stats[0] = attackValue; stats[1] = damage;
        return stats;
    }

    abstract int evaluate(int attackValue, Beast enemy);

    public int getOriginalResistance() {
        return originalResistance;
    }
}
