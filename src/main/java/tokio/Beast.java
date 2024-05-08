package tokio;

public class Beast extends Character{
    Dice dice = new Dice();
    public Beast(String name, int hp, int resistance) {
        super(name, hp, resistance);
    }

    @Override
    int attack(Character attacker, Character defensor) {
        int attackValue = dice.throwDice(attacker, 1);
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
}
