package tokio;

import java.util.Random;

public class Dice {
    private Random random = new Random();

    public int throwDice(Character character, int count) {
        int maxValue = Integer.MIN_VALUE;
        while(count>0) {
            int diceValue;
            if(character instanceof Hero) {
                if(count>1) System.out.println("I am a hero");
                //diceValue = random.nextInt(101); // random number between 0 and 100
                diceValue = 1 + random.nextInt(5); // tests random between 1 and 5
                System.out.println("dice: " + diceValue); // test if max works
            }
            else {
                System.out.println("I am a beast");
                //diceValue = random.nextInt(91); // random number between 0 and 90
                diceValue = 3;
                System.out.println("dice: " + diceValue);
            }
            maxValue = Math.max(diceValue, maxValue);
            count--;
        }
        return maxValue;
    }
}
