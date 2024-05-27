package tokio;

abstract class Beast extends Character{
    Dice dice = new Dice();
    public Beast(String name, int hp, int resistance) {
        super(name, hp, resistance);
    }


    // método de ataque da classe beast - retorna um array com o valor de ataque e o dano causado
    @Override
    int[] attack(Character defensor) {
        int[] stats = new int[2];
        int attackValue = dice.throwDice(this, 1); // valor de ataque calculado com o lançamento do dado
        int resistance = evaluate(defensor.getResistance(), (Hero) defensor); // valor da resistência do adversário
        defensor.setResistance(resistance);
        int damage = attackValue - resistance; // cálculo do dano
        if(damage>0) defensor.setHp(defensor.getHp() - damage);
        else damage = 0; // dano não pode ser negativo para prevenir que aumente a vida do adversário
        stats[0] = attackValue; stats[1] = damage;
        return stats;
    }

    // avalia efeitos que a besta tem sobre as defesas do adversário
    abstract int evaluate(int resistance, Hero enemy);
}
