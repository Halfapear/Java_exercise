/** // <-- Javadoc 注释开始
 * 这是一个简单的计算器类，可以执行加法操作。 // <-- 这是描述部分
 * 它提供了一个静态方法来计算两个整数的和。
 *
 * @author 张三  // <-- @author 标签：说明作者
 * @version 1.0 // <-- @version 标签：说明版本
 */
public class SimpleCalculator {

    /** // <-- 针对方法的 Javadoc 注释开始
     * 计算两个整数的和。 // <-- 方法描述
     *
     * @param number1 第一个要相加的整数。 // <-- @param 标签：说明第一个参数
     * @param number2 第二个要相加的整数。 // <-- @param 标签：说明第二个参数
     * @return 两个整数的和。          // <-- @return 标签：说明返回值
     */
    public static int add(int number1, int number2) {
        return number1 + number2;
    }

    // ------------ 新增的 main 方法开始 ------------
    /**
     * 程序的主入口点，用于演示 add 方法。
     * @param args 命令行参数（在这个例子中未使用）。
     */
    public static void main(String[] args) {
        // 1. 定义两个要相加的数字
        int numA = 15;
        int numB = 7;

        // 2. 调用 add 方法计算它们的和
        // 因为 main 和 add 都在同一个类中，且都是 static，可以直接调用 add
        int sum = add(numA, numB);
        // 或者用类名调用： int sum = SimpleCalculator.add(numA, numB);

        // 3. 在控制台打印结果
        System.out.println("计算 " + numA + " + " + numB);
        System.out.println("结果是: " + sum);

        // 你也可以直接在 println 中调用方法
        System.out.println("直接计算 10 + 5 的结果是: " + add(10, 5));
    }
    // ------------ 新增的 main 方法结束 ------------

    // 假设还有其他方法，比如 subtract, multiply 等
}