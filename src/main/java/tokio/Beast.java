package tokio;

abstract class Beast extends Character{
    Dice dice = new Dice();
    public Beast(String name, int hp, int resistance) {
        super(name, hp, resistance);
    }


    @Override
    int[] attack(Character defensor) {
        int[] stats = new int[2];
        int attackValue = dice.throwDice(this, 1);
        int resistance = evaluate(defensor.getResistance(), (Hero) defensor);
        defensor.setResistance(resistance); // verificar melhor quando se implementar turnos
        int damage = attackValue - resistance;
        if(damage>0) defensor.setHp(defensor.getHp() - damage);
        else damage = 0;
        stats[0] = attackValue; stats[1] = damage;
        return stats;
    }

    abstract int evaluate(int resistance, Hero enemy);
}
