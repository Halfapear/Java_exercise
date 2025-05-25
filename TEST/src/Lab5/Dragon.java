package Lab5;

import java.util.Random;

public class Dragon extends Monster{
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
     * 实现 Monster 类中定义的抽象方法 specialAttack。
     * 龙的特殊攻击是喷火。
     * @return 喷火造成的伤害值 (1 到 50)
     */
    @Override
    public int specialAttack(){
        Random random = new Random();
        // 直接执行喷火攻击的逻辑
        int damage = random.nextInt(MAX_FIRE_DAMAGE) + 1;
        String classType = this.getClass().getSimpleName();
        System.out.println(this.name + ", of type " + classType + ", attacks by breathing fire: " + damage + " points damage caused.");
        return damage;
    }
    
}
