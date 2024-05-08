package tokio;

abstract class Hero extends Character {
    Dice dices = new Dice();

    public Hero(String name, int hp, int resistance) {
        super(name, hp, resistance);
    }

    @Override
    int attack(Character attacker, Character defensor) {
        int attackValue = dices.throwDice(attacker, 2);
        System.out.println("dice: " + attackValue);
        attackValue = evaluate(attackValue, (Beast) defensor);
        System.out.println("My attack is: " + attackValue);
        System.out.println("My opponent resistance is: " + defensor.getResistance());
        int damage = attackValue - defensor.getResistance();
        if(damage>0) {
            System.out.println("Damage: " + damage);
            defensor.setHp(defensor.getHp() - damage);
        }
        else System.out.println("No damage");
        return damage;
    }

    abstract int evaluate(int attackValue, Beast enemy);
}
