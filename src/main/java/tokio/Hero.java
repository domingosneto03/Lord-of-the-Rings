package tokio;

abstract class Hero extends Character {
    Dice dices = new Dice();
    private int originalResistance;

    public Hero(String name, int hp, int resistance) {
        super(name, hp, resistance);
        originalResistance = resistance;
    }

    // método de ataque da classe hero - retorna um array com o valor de ataque e o dano causado
    @Override
    int[] attack(Character defensor) {
        int[] stats = new int[2];
        int attackValue = dices.throwDice(this, 2); // valor de ataque calculado com o lançamento dos dados
        attackValue = evaluate(attackValue, (Beast) defensor); // valor de ataque recalculado dependendo de quem é o seu adversário
        int damage = attackValue - defensor.getResistance(); // cálculo do dano
        if(damage>0) defensor.setHp(defensor.getHp() - damage);
        else damage = 0; // dano não pode ser negativo para prevenir que aumente a vida do adversário
        stats[0] = attackValue; stats[1] = damage;
        return stats;
    }

    // avalia efeitos que o ataque do heroi tem sobre o adversário
    abstract int evaluate(int attackValue, Beast enemy);

    public int getOriginalResistance() {
        return originalResistance;
    }
}
