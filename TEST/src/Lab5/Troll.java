/**
 * Troll 类代表一种特殊的怪物——巨魔。
 * 巨魔继承自 Monster 类，并且对其命名有特殊限制。
 */

package Lab5;

import java.util.Random;
//import java.util.random.RandomGenerator;

public class Troll extends Monster{
    private static final String DEFAULT_TROLL_NAME = "Detritus";
    private static final String FORBIDDEN_NAME_1 = "Saul";
    private static final String FORBIDDEN_NAME_2 = "Salomon";

    private static final int MAX_STICK_DAMAGE = 15;
    
    //所以说 static就是一个变量只能在这个类中用（子类也用不了 —— 不对 子类能不能访问只要有protected 或 public就行
    //解决的是“成员属于谁”的问题 static表示对象属于类；
    //如果一个成员（字段或方法）没有 static 修饰符，那么它就是 实例成员 (Instance Member)
    //final 到底是什么 如果static是这样 那final不就没用了吗
    //fianl 其实是 不可变-不能修改 不可拓展-这个类不能被其他类继承+不可重写
    
    //RandomGenerator RandomGenerator = SomeRandomGeneratorImpl.create();// 这样的代码来获取一个生成器实例。
    //算了 不这样写
    // 为 Troll 类创建一个 Random 实例，可以在多个方法中复用
    private Random randomGenerator = new Random();

    /**
     * Troll 类的构造函数。
     * 如果提供的名字是 "Saul" 或 "Salomon"，则名字会被设为 "Detritus"，并打印错误信息。
     * @param name 尝试为巨魔设定的名字
     */
    public Troll(String name){
        super(processName(name));
    }

    public Troll(String name, double spAttackProbability){
        super(processName(name), spAttackProbability);
        //疑问 这边super就能代表monster那一些ifelse？不是说要么代表父类 要么代表父类方法吗
        //——启动了 Monster 类的这个双参数构造函数 其实是直接连上父类的构造函数
        //那问题来了 为什么不能直接在需要用构造函数的时候再super 
        //——你是不是忘了 这种super代表方法的 只有一种情况：super(...) 调用（如果需要）必须是子类构造函数中的第一条可执行语句
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
        }
        return requestedName;
    }

    /**
     * 实现 Monster 类中定义的抽象方法 specialAttack。
     * 巨魔的特殊攻击是用棍子敲打。
     * @return 棍击造成的伤害值 (1 到 15)
     */
    @Override
    public int specialAttack(){
        //问 为什么这边括号不输入 
        int damage = randomGenerator.nextInt(MAX_STICK_DAMAGE) + 1 ;
        //我怀疑这里random用不了 因为monster那边用了private
        //不对 好戏有个java.util.random.RandomGenerator在前面
        //不行 RG是一个接口 还是得创造实例
        //两种改进方法 一种是把monster里面的这个该public 一种是用Math是吧

        String classType = this.getClass().getSimpleName();
        System.out.println(this.name + ", of type " + classType + ", bashes with a stick (special): " + damage + " points damage caused.");
        return damage;

    }

    public int age() {

        return randomGenerator.nextInt();
    }

}
