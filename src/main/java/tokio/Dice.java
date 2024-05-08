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
                diceValue = random.nextInt(101); // random number between 0 and 100
            }
            else {
                System.out.println("I am a beast");
                diceValue = random.nextInt(91); // random number between 0 and 90
            }
            maxValue = Math.max(diceValue, maxValue);
            count--;
        }
        return maxValue;
    }
}
