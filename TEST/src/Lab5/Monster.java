package Lab5;

import java.util.Random;
/**
 * Monster 类代表游戏中的一个通用怪物。
 * 这是一个抽象类，不能被直接实例化。
 * 每个怪物都有一个名字、特殊攻击概率，并且可以攻击和移动。
 */
public abstract class Monster { // 声明为抽象类
    //等一下 抽象类下面还能接这么多东西吗 —— 当然可以 区别只在于两点1 不能被new（也就是实例化）2 具体类不能包含抽象方法 抽象类可以
    protected String name;
    protected double spAttackProbability; // 特殊攻击概率

    private Random randomGenerator = new Random(); // 创建一个Random实例供类内使用
    //话说 这个能写public方便子类用吗 —— 技术上可以，但不推荐；看来java不喜欢一脉相承 每个类都喜欢独立 - 准确来说是高内聚 低耦合

    // 默认特殊攻击概率值
    private static final double DEFAULT_SP_ATTACK_PROBABILITY = 0.2;

    /**
     * Monster 类的构造函数 (只设置名字)。
     * 特殊攻击概率使用默认值。
     * @param name 怪物的名字
     */
    public Monster(String name){
        this(name, DEFAULT_SP_ATTACK_PROBABILITY);
    }

    /**
     * Monster 类的构造函数 (设置名字和特殊攻击概率)。
     * @param name 怪物的名字
     * @param spAttackProbability 怪物的特殊攻击概率
     */
    public Monster(String name, double spAttackProbability) {
        this.name = name;
        if (spAttackProbability >= 0.0 && spAttackProbability <= 1.0) {
            this.spAttackProbability = spAttackProbability;
        } else {
            System.err.println("Warning: spAttackProbability for " + name + " (" + spAttackProbability + ") is out of range [0.0, 1.0]. Using default: " + DEFAULT_SP_ATTACK_PROBABILITY);
            this.spAttackProbability = DEFAULT_SP_ATTACK_PROBABILITY;
        }
    }

        /**
     * 获取怪物的名字。
     * @return 怪物的名字
     */
    public String getName() {
        return this.name;
    }

        /**
     * 获取怪物的特殊攻击概率。
     * @return 特殊攻击概率
     */
    // spAttackProbability 的 getter (如果需要从外部读取)
    public double getSpAttackProbability() {
        return this.spAttackProbability;
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
     * 怪物进行攻击。此方法是 final 的，子类不能重写。
     * 攻击可能是特殊攻击或通用攻击，取决于 spAttackProbability。
     * @return 造成的伤害值
     */
    public final int attack(){
        if(randomGenerator.nextDouble() < this.spAttackProbability){
        //这里必须写this 方便子类用的（不过 一般都会直接写this）准确来说 就是多态性 (Polymorphism) 的体现
            // 执行特殊攻击
            return this.specialAttack();
        }
        else{
            // 执行通用攻击
            int damage = randomGenerator.nextInt(5) + 1; // 1 到 5 点伤害
            String classType = this.getClass().getSimpleName();
            System.out.println(this.name + ", of type " + classType + ", attacks generically: " + damage + " points damage caused.");
            return damage;

        }
    }

    /**
     * 抽象方法：特殊攻击。
     * 每个具体的怪物子类都必须实现这个方法来定义其独特的特殊攻击行为。
     * @return 特殊攻击造成的伤害值
     */
    public abstract int specialAttack();



}
