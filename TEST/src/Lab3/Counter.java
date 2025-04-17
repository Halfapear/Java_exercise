package Lab3


/**
 * Counter 类代表一个简单的计数器。
 * 它有一个当前值 (count) 和一个最大值 (max)。
 * (注意：此时的方法尚未完全实现边界检查)
 *
 * @version 0.4 (完成步骤 3.iv)
 */
public class Counter {

    // 实例变量
    private int count; // 当前计数值
    private int max;   // 允许的最大计数值

    /**
     * 默认构造函数。
     * 初始化 count 为 0，max 为 10。
     */
    public Counter() {
        this.count = 0;
        this.max = 10;
        // System.out.println("默认 Counter 对象已创建: count=0, max=10"); // 调试输出
    }

    // --- Getter 方法 ---

    /**
     * 获取当前的计数值。
     * @return 当前的 count 值。
     */
    public int getCount() {
        return this.count;
    }

    /**
     * 获取计数器的最大值。
     * @return 当前的 max 值。
     */
    public int getMax() {
        return this.max;
    }

    // --- Setter 方法 ---

    /**
     * 设置当前的计数值。
     * (没有边界检查)
     * @param n 要设置的新的 count 值。
     */
    public void setCount(int n) {
        this.count = n;
    }

    /**
     * 设置计数器的最大值。
     * @param n 要设置的新的 max 值。
     */
    public void setMax(int n) {
        this.max = n;
    }

    // --- 行为方法 (截至步骤 3.iv) ---

    /**
     * 将计数值增加 2。
     * (此时不检查是否超过 max)
     */
    public void increase() {
        this.count = this.count + 2;
        System.out.println("调用了 increase(), 当前 count = " + this.count); // 添加输出来观察
    }

    /**
     * 将计数值减少 1。
     * (此时不检查是否小于 0)
     */
    public void decrease() {
        this.count = this.count - 1;
         System.out.println("调用了 decrease(), 当前 count = " + this.count); // 添加输出来观察
    }

    /**
     * 将计数值加倍。
     * (此时不检查是否超过 max)
     */
    public void doubler() {
        this.count = this.count * 2;
        System.out.println("调用了 doubler(), 当前 count = " + this.count); // 添加输出来观察
    }

    /**
     * 将计数值重置为 0，并打印一条消息。
     */
    public void reset() {
        this.count = 0;
        System.out.println("Counter Reset!"); // 按要求打印消息
        System.out.println("调用了 reset(), 当前 count = " + this.count); // 添加输出来观察
    }

    @Override
public String toString(){
    return "Counter[count=" + this.count + ", max=" + this.max + "]";
    
    // TEst
}

} // End of Counter class