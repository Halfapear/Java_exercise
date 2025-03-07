public class App {
    // 加法方法
    public int add(int a, int b) {
        return a + b;
    }

    // 减法方法
    public int subtract(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        App app = new App();  // 直接使用 App 类作为计算器
        System.out.println("10 + 5 = " + app.add(10, 5));
        System.out.println("10 - 5 = " + app.subtract(10, 5));
    }
}
