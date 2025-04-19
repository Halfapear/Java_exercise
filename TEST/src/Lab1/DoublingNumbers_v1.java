package Lab1;

public class DoublingNumbers_v1 {

    // 你可以将 n 定义为静态变量，或者直接在 main 方法内部定义
    // static int n = 1; // 或者 2, 或其他值

    public static void main(String[] args) {
        int n = 1; // 或者从命令行参数、用户输入等获取 n 的值

        if (n == 1) {
            System.out.println("Executing version 1 (do-while):");
            int i = 1;
            do {
                System.out.println("The double of " + i + " is " + 2 * i);
                i++;
            } while (i <= 12);
            // 关于你的注释 "// 12是不对的！i这里应该是<=11"：
            // 如果你希望包含 12 的倍数，那么 i <= 12 是正确的。
            // do-while 循环会先执行一次循环体，然后检查条件。
            // 当 i = 12 时，打印 2*12=24，然后 i 变成 13，
            // 此时 13 <= 12 为 false，循环结束。
            // 如果你只想到 11 的倍数，才应该用 i <= 11。

        } else if (n == 2) {
            System.out.println("Executing version 2 (while):");
            int i = 1;
            while (i <= 12) { // 这个循环也会打印到 12 的倍数
                // 注意：这里你代码里有个拼写错误 "doubel" -> "double"
                System.out.println("The double of " + i + " is " + 2 * i);
                i++;
            }
        } else if (n == 3) {
            for(int i=1 ;i<=12;i++){
                System.out.println("The double of " + i + " is " + 2 * i);
            }
        } else {
            System.out.println("Unknown version: " + n);
        }

        // 如果想看循环结束后 i 的值（仅在 n=1 或 n=2 时有意义且需调整作用域）
        // 需要将 i 的声明移到 if 外部，例如：
        // int i = 1;
        // if (n == 1) { ... i++; } while(...); System.out.println("Final i: " + i);
        // else if (n == 2) { ... i++; } System.out.println("Final i: " + i);

    }
}