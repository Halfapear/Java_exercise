package Lab5;


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

    
}
