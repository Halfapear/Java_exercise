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

        System.out.println("开始掷骰子，目标是三个骰子都为6...");
        do { 
            dice1 = random.nextInt(6) + 1;
            dice2 = random.nextInt(6) + 1;
            dice3 = random.nextInt(6) + 1;
            rollCount++;

            //nextInt(6) generate 0-5
        } while (!(dice1 == 6 && dice2 == 6 && dice3 == 6));
        //ps 这个取反稍微要想一下
        // 循环结束，意味着三个骰子都为6
        System.out.println("恭喜！三个骰子都掷出了6！");
        System.out.println("在第 " + rollCount + " 次掷骰子时达成目标。");
        System.out.println("最终结果: " + dice1 + ", " + dice2 + ", " + dice3);
    }
}
