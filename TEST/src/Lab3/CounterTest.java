/**
 * CounterTest 类用于测试 Counter 类的基本功能 (截至步骤 3.iv)。
 * 包括构造函数、getter/setter、increase, decrease, doubler, reset。
 *
 * @version 0.4 (测试步骤 3.iv)
 */
public class CounterTest {

    /**
     * main 方法，程序的入口点。
     * @param args 命令行参数 (未使用)。
     */
    public static void main(String[] args) {

        // --- 1. 测试构造函数 和 Getters/Setters ---
        System.out.println("\n--- 1. 测试构造函数和 Getters/Setters ---");
        Counter myCounter = new Counter(); // 调用默认构造函数

        // 打印初始值 (使用 Getters)
        System.out.println("初始 Count: " + myCounter.getCount()); // 预期: 0
        System.out.println("初始 Max: " + myCounter.getMax());     // 预期: 10

        // 使用 Setters 修改值
        System.out.println("\n使用 Setters 设置 count=5, max=20...");
        myCounter.setCount(5);
        myCounter.setMax(20);

        // 打印修改后的值 (使用 Getters)
        System.out.println("修改后 Count: " + myCounter.getCount()); // 预期: 5
        System.out.println("修改后 Max: " + myCounter.getMax());     // 预期: 20

        // --- 2. 测试基本操作方法 (increase, decrease, doubler, reset) ---
        System.out.println("\n--- 2. 测试基本操作方法 ---");
        Counter counter2 = new Counter(); // 创建一个新的 Counter (count=0, max=10)
        System.out.println("新计数器初始状态: count=" + counter2.getCount() + ", max=" + counter2.getMax());

        // 测试 increase()
        System.out.println("\n测试 increase():");
        counter2.increase(); // count 应该变成 0 + 2 = 2

        // 测试 decrease()
        System.out.println("\n测试 decrease():");
        counter2.decrease(); // count 应该变成 2 - 1 = 1

        // 测试 doubler()
        // 先设置一个值方便看效果
        counter2.setCount(5);
        System.out.println("\n设置 count = 5");
        System.out.println("测试 doubler():");
        counter2.doubler(); // count 应该变成 5 * 2 = 10

        // 测试 reset()
        System.out.println("\n测试 reset():");
        counter2.reset(); // count 应该变成 0，并打印 "Counter Reset!"


        System.out.println("\n--- 测试 toString() 方法 ---");
        Counter counter3 = new Counter();

        counter3.setCount(7);
        counter3.setMax(15);

        // 直接打印对象，会自动调用 toString() 方法
        System.out.println("打印 counter3 对象: " + counter3);
        // 或者显式调用 toString()
        String counterState = counter3.toString();
        System.out.println("显式调用 toString(): " + counterState);

        System.out.println("\n--- 测试 increase() 和 decrease() 的边界条件 ---");
        Counter boundaryCounter = new Counter(); // 默认 max=10
        System.out.println("初始状态: " + boundaryCounter);
    
        // 测试 increase() 边界
        System.out.println("连续调用 increase() 直到重置:");
        for (int i = 0; i < 7; i++) { // 尝试调用多次 (例如 7 次)
            System.out.print("调用 increase() 前: " + boundaryCounter.getCount() + " -> ");
            boundaryCounter.increase();
            System.out.println("调用后: " + boundaryCounter.getCount());
            // 预期: 0->2, 2->4, 4->6, 6->8, 8->0 (因为 8+2=10 >= max=10), 0->2, 2->4
        } 
        System.out.println("Increase 边界测试结束，最终状态: " + boundaryCounter);
    
        // 测试 decrease() 边界
        System.out.println("\n将 count 设置为 1，然后连续调用 decrease():");
        boundaryCounter.setCount(1);
        System.out.println("设置后状态: " + boundaryCounter);
        for (int i = 0; i < 3; i++) { // 尝试调用多次
            System.out.print("调用 decrease() 前: " + boundaryCounter.getCount() + " -> ");
            boundaryCounter.decrease();
            System.out.println("调用后: " + boundaryCounter.getCount());
            // 预期: 1->0, 0->0, 0->0
        }
        System.out.println("Decrease 边界测试结束，最终状态: " + boundaryCounter);
    
        System.out.println("\n边界条件测试完成。");

        System.out.println("\n--- 测试重载方法 increase(n) 和 decrease(n) ---");
        Counter overloadCounter = new Counter(); // max=10
        overloadCounter.setCount(3);
        System.out.println("初始状态: " + overloadCounter); // count=3, max=10
    
        // 测试 increase(int n)
        System.out.println("调用 increase(5)..."); // 3 + 5 = 8
        overloadCounter.increase(5);
        System.out.println("当前状态: " + overloadCounter); // count=8, max=10
    
        System.out.println("调用 increase(3)..."); // 8 + 3 = 11 >= 10 -> 重置为 0
        overloadCounter.increase(3);
        System.out.println("当前状态: " + overloadCounter); // count=0, max=10
    
        // 测试 decrease(int n)
        overloadCounter.setCount(9); // 设置 count=9
        System.out.println("\n设置 count = 9. 当前状态: " + overloadCounter);
    
        System.out.println("调用 decrease(4)..."); // 9 - 4 = 5
        overloadCounter.decrease(4);
        System.out.println("当前状态: " + overloadCounter); // count=5, max=10
    
        System.out.println("调用 decrease(7)..."); // 5 - 7 < 0 -> 设置为 0
        overloadCounter.decrease(7);
        System.out.println("当前状态: " + overloadCounter); // count=0, max=10
    
        System.out.println("调用 decrease(2)..."); // 0 - 2 (count已经是0) -> 保持 0
        overloadCounter.decrease(2);
        System.out.println("当前状态: " + overloadCounter); // count=0, max=10
    
        System.out.println("\n方法重载测试完成。");

        }

        

} // End of CounterTest class