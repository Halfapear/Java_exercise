package Lab1;

public class TestArgs {
    public static void main(String[] args){
        if (args.length < 4) {
            System.out.println("错误：参数不足！");
            System.out.println("用法: java TestArgs <名字> <姓氏> <BUPT用户名> <QMUL学号>");
            System.out.println("示例: java TestArgs Ada Lovelace jp2023213117 230675602");
            return; // 提前退出程序
        }

        // 2. 从 args 数组中获取参数
        // args[0] 存储第一个参数 "Ada"
        // args[1] 存储第二个参数 "Lovelace"
        // args[2] 存储第三个参数 "jp2023213117"
        // args[3] 存储第四个参数 "230675602"

        // 3. 组合名字和姓氏
        String firstName = args[0];
        String lastName = args[1];
        String fullName = firstName + " " + lastName; // 用空格连接

        // 4. 获取其他信息
        String buptUsername = args[2];
        String qmulNumber = args[3];

        // 5. 按要求格式打印输出
        System.out.println("Name                = " + fullName);
        System.out.println("BUPT email username = " + buptUsername);
        System.out.println("QMUL student number = " + qmulNumber);
    }
}
