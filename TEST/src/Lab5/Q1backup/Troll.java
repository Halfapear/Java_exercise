/**
 * Troll 类代表一种特殊的怪物——巨魔。
 * 巨魔继承自 Monster 类，并且对其命名有特殊限制。
 */

package Lab5;

public class Troll extends Monster{
    private static final String DEFAULT_TROLL_NAME = "Detritus";
    private static final String FORBIDDEN_NAME_1 = "Saul";
    private static final String FORBIDDEN_NAME_2 = "Salomon";
    
    /**
     * Troll 类的构造函数。
     * 如果提供的名字是 "Saul" 或 "Salomon"，则名字会被设为 "Detritus"，并打印错误信息。
     * @param name 尝试为巨魔设定的名字
     */
    public Troll(String name){
        super(processName(name));
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

    // Troll 类在这个阶段不需要重写 attack() 或 move() 方法，
    // 它将直接继承 Monster 类的这些行为。

}
