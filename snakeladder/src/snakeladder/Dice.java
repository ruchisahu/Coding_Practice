package snakeladder;

import java.util.Random;

public class Dice {
    private int min;
    private int max;
    private int currentValue;


	public int roll(Random rn, int min, int max) {
    	
        return (int)(rn.nextInt(((int) max) - min + 1) + min);
    }
    public Dice(int min, int max, int curr) {
        this.min=min;
        this.max=max;
        this.currentValue=curr;
    }
}
