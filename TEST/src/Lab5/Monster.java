package Lab5;

import java.util.ArrayList;
import java.util.Random;

public class Monster {
    protected String name; // 怪物的名字 (protected 允许子类直接访问)
    
        /**
     * Monster 类的构造函数。
     * @param name 怪物的名字
     */
    public Monster(String name) {
        this.name = name;
    }

        /**
     * 获取怪物的名字。
     * @return 怪物的名字
     */
    public String getName() {
        return this.name;
    }

    public String getName(){
        return this.name;
    }

    public void move(int direction) {
        switch(direction) {
            case 1:
                System.out.println(this.name + " is moving 1 step NORTH.");
                break;
            case 2:
                System.out.println(this.name + " is moving 1 step EAST.");
                break;
            case 3:
                System.out.println(this.name + " is moving 1 step SOUTH.");
                break;
            default: // Assumed to be case 4 or any other for WEST
                System.out.println(this.name + " is moving 1 step WEST.");
                break;
        }
    }

        /**
     * 怪物进行一次通用攻击。
     * 攻击会造成1到5点之间的随机伤害。
     * @return 造成的伤害值
     */
    public int attack() {
        // 生成1到5之间的随机数:
        // Math.random() -> [0.0, 1.0)
        // Math.random() * 5 -> [0.0, 5.0)
        // (int)(Math.random() * 5) -> 0, 1, 2, 3, 4
        // (int)(Math.random() * 5) + 1 -> 1, 2, 3, 4, 5
        Random random = new Random();
        int damage = random.nextInt(5) + 1; // random.nextInt(N) 生成 0 到 N-1 的数

        // this.getClass() 返回对象的运行时类
        // .getSimpleName() 返回类的简称 (例如 "Monster", "Dragon")
        //这行 Java 代码的目的是获取当前对象实际运行时的类名（不包含包名），并将其存储在一个名为 classType 的字符串变量中。
        String classType = this.getClass().getSimpleName();

        System.out.println(this.name + ", of type " + classType + ", attacks generically: " + damage + " points damage caused.");
        return damage;
    }
    


    
    public class TestingMonsters {
    public static void main(String[] args) {
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
        }
    }

}
