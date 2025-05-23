package Lab5;

import java.util.Random;

public class Dragon extends Monster{
    private static final double FIRE_BREATH_CHANCE = 0.3; // 喷火概率常量
    private static final int MAX_FIRE_DAMAGE = 50;       // 喷火最大伤害
    private Random randomGenerator = new Random(); // 龙自己的随机数生成器 (或者可以考虑从父类继承/传递)

    /**
     * Dragon 类的构造函数。
     * @param name 龙的名字
     */
    public Dragon(String name){
        super(name);
        // 调用父类 Monster 的构造函数1
    }   

    /**
     * 构造函数：提供名字和特殊攻击概率。
     * @param name 龙的名字
     * @param spAttackProbability 龙的喷火概率
     */
    public Dragon(String name, double spAttackProbability) {
        super(name, spAttackProbability); // 调用 Monster(String name, double spAttackProbability)
    }
    
    /**
     * 龙进行攻击。
     * 有 30% 的概率喷火，造成 1-50 点伤害。
     * 否则，进行一次通用攻击。
     * @return 造成的伤害值
     */
    @Override
    public int attack(){
        Random random = new Random();
        if (random.nextDouble() < FIRE_BREATH_CHANCE){
            //random.nextDouble(): 这个方法调用会返回一个伪随机的 double (双精度浮点数) 类型的值。这个值的范围是 [0.0, 1.0)，也就是说，它大于或等于 0.0，并且严格小于 1.0。
            // 1 到 50 的伤害
            int damage = random.nextInt(MAX_FIRE_DAMAGE) + 1;
            //"Dragon"
            String classType = this.getClass().getSimpleName();
            System.out.println(this.name + ", of type " + classType + ", attacks by breathing fire: " + damage + " points damage caused.");
            return damage ;
        }
        else {
            // 通用攻击 (调用父类 Monster 的 attack 方法)
            return super.attack();

        }
    }
    
}
