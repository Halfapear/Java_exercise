/*
 * javac ThreeRollingDice.java
 * java ThreeRollingDice
 */

import java.util.Random;

//package Lab7;

public class ThreeRollingDice {
    public static void main(String[] args){
        Random random = new Random();
        int dice1, dice2, dice3;
        int rollCount = 0;

        System.out.println("Starting to roll the dice, aiming for three sixes...");
        do { 
            dice1 = random.nextInt(6) + 1;
            dice2 = random.nextInt(6) + 1;
            dice3 = random.nextInt(6) + 1;
            rollCount++;

            //nextInt(6) generate 0-5
        } while (!(dice1 == 6 && dice2 == 6 && dice3 == 6));
        //ps 这个取反稍微要想一下
        // 循环结束，意味着三个骰子都为6
        System.out.println("Congratulations! Rolled three sixes!");
        System.out.println("Achieved the goal on the " + rollCount + " roll.");
        System.out.println("Final result: " + dice1 + ", " + dice2 + ", " + dice3);
    }
}
