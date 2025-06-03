/*
 * javac Lab5/TestingMonsters.java
 * java Lab5.TestingMonsters
 */

package Lab5;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

    public class TestingMonsters {
    public static void main(String[] args) {
        /* 
        ArrayList<Monster> monsters = new ArrayList<Monster>();

        monsters.add(new Monster("Tom"));
        monsters.add(new Monster("George"));

        monsters.add(new Dragon("Smaug"));
        monsters.add(new Dragon("Jabosh"));

        monsters.add(new Troll("Salomon"));
        monsters.add(new Troll("Bender"));

            int damageDone = 0;
            while (damageDone < 100) {
                for (Monster m : monsters) {
                    m.move((int)(Math.random()*4) + 1);
                damageDone += m.attack();
                }
            }
        */
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        monsters.add(new Dragon("Smaug"));
        //这就是new拿下来... 这是
        monsters.add(new Dragon("Jabosh",0.6));

        //Random Math = new Random();
        //根本不知道格式！—— Random是java.util包里面的类 所以是正常的前面声明 后面new 然后记得带括号（没有输入总是忘记）
        //哦等下 Math就是一个类

        // 添加 Troll 实例
        // "Salomon" 是 Troll 的禁用名，会被自动改为 "Detritus"
        monsters.add(new Troll("Salomon")); // 会被命名为 Detritus, 使用默认 spAttackProbability (0.2)
        monsters.add(new Troll("Bender", 0.15)); // Bender 有 15% 概率特殊攻击, 名字合法
        monsters.add(new Troll("Saul"));

        // 初始化一个整型变量 damageDone，用于累计所有怪物造成的总伤害。
        int damageDone = 0;
        while (damageDone < 100) {
            for (Monster m : monsters) {
            //增强型 for 循环 (enhanced for loop)，也常被称为 for-each 循环。它提供了一种简洁的方式来遍历数组或集合（如 ArrayList）中的所有元素
            //冒号是增强型 for 循环语法中用来分隔“元素声明”和“要遍历的集合/数组”的符号。你可以把它读作“in”或“中的每一个”
            //m: 这是循环变量 (elementVariable) 的名字。在循环的每一次迭代中，monsters 列表中的一个元素会被自动赋值给这个变量 m。你可以把它看作是当前正在处理的那个怪物的临时名字
            m.move((int)(Math.random()*4)+1);
                damageDone += m.attack();
            }
        }
        
/*
        //别整这么复杂的 你就写一个这个的改版
        // 打印出所有怪物的信息，包括它们的特殊攻击概率，以供验证
        System.out.println("--- Monster Roster ---");
        for (Monster m : monsters) {
            System.out.println("Name: " + m.getName() +
                               ", Type: " + m.getClass().getSimpleName() +
                               ", SP Attack Prob: " + m.getSpAttackProbability());
        }
        System.out.println("----------------------\n");


        int damageDone = 0;
        int round = 1;
        System.out.println("--- Battle Simulation (Target Damage: 100) ---");
        while (damageDone < 100) {
            System.out.println("\n--- Round " + round + " ---");
            for (Monster m : monsters) {
                if (damageDone >= 100) break; // 如果在一轮中途达到目标，则停止

                // 移动怪物 (1:N, 2:E, 3:S, 4:W)
                // (int)(Math.random()*4) + 1 会生成 1, 2, 3, 4
                int direction = randomDirectionGenerator.nextInt(4) + 1;
                m.move(direction);

                // 怪物攻击
                System.out.print(m.getName() + " (" + m.getClass().getSimpleName() + ") attacks: ");
                int currentAttackDamage = m.attack(); // attack() 内部会决定是通用攻击还是特殊攻击
                damageDone += currentAttackDamage;

                System.out.println("Total damage so far: " + damageDone);
            }
            round++;
            if (damageDone >= 100) {
                System.out.println("\n--- Target damage of 100 reached or exceeded! ---");
            }
        }
        System.out.println("Final total damage: " + damageDone + " after " + (round-1) + " rounds.");
 */
        
        }
    }