/**
 * Troll 类代表一种特殊的怪物——巨魔。
 * 巨魔继承自 Monster 类，并且对其命名有特殊限制。
 */

package Lab5;

import java.util.Random;

public class Troll extends Monster{
    private static final String DEFAULT_TROLL_NAME = "Detritus";
    private static final String FORBIDDEN_NAME_1 = "Saul";
    private static final String FORBIDDEN_NAME_2 = "Salomon";
    private static final int MAX_STICK_DAMAGE = 15; // 棍击最大伤害
    private Random randomGenerator = new Random();

    
    /**
     * Troll 类的构造函数。
     * 如果提供的名字是 "Saul" 或 "Salomon"，则名字会被设为 "Detritus"，并打印错误信息。
     * @param name 尝试为巨魔设定的名字
     */
    public Troll(String name){
        super(processName(name));
        //代表着monster里面的构造函数吗 —— 没错

    }

        /**
     * 构造函数：提供名字和特殊攻击概率。
     * 会检查并处理不合法的名字。
     * @param name 尝试为巨魔设定的名字
     * @param spAttackProbability 巨魔的特殊攻击概率
     */

    public Troll(String name, double spAttackProbability){
        super(processName(name), spAttackProbability);
    }
    /**
     * 私有辅助方法，用于处理巨魔的名字。
     * @param requestedName 用户请求的名字
     * @return 最终确定的名字
     */
        private static String processName(String requestedName) {
        if (FORBIDDEN_NAME_1.equalsIgnoreCase(requestedName) || FORBIDDEN_NAME_2.equalsIgnoreCase(requestedName)) {
            System.err.println("Error: Trolls cannot be named '" + requestedName + "'. Naming this troll '" + DEFAULT_TROLL_NAME + "'.");
            return DEFAULT_TROLL_NAME;
            //equalsIgnoreCase 什么意思？ —— “忽略大小写比较相等 (Ignore Case Equals)”
        }
        return requestedName;
    }

    /**
     * 实现 Monster 类中定义的抽象方法 specialAttack。
     * 巨魔的特殊攻击是用棍子敲打。
     * @return 棍击造成的伤害值 (1 到 15)
     */
    //首先为什么他用 public？ —— specialAttack是 attack的一部分
    //其次，为什么不写 static 了 —— 
    @Override
    //你应该知道Override属于多态吧
    public int specialAttack(){
        int damage = randomGenerator.nextInt(MAX_STICK_DAMAGE) + 1; // 1 到 15 点伤害
        //我们确实知道 this.getClass().getSimpleName() 的结果会是 "Troll"，但不直接填写真字符串 "Troll" —— 编写更通用和可维护的代码，避免硬编码
        String classType = this.getClass.getSimpleName();
        System.out.println(this.name + ", of type " + classType + ", bashes with a stick (special): " + damage + " points damage caused.");
        return damage;
    }
    

}
