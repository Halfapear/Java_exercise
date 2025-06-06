package Lab8;
/*
 * 编译：javac ParityBitAdder.java
 * java ParityBitAdder 1010011 0
 * 01010011
 * 奇偶校验的逻辑是什么 —— 比如even就是目标: 使得整个数据串（原始数据 + 校验位）中 '1' 的总个数为偶数
 * java ParityBitAdder 1010011 1
 * Adding odd parity to '1010011' results in the binary pattern '11010011'.
 * 错误
 * java ParityBitAdder 1010011
 * java ParityBitAdder 1010211 0
 * java ParityBitAdder 10100110 0
 * java ParityBitAdder 1010011 2
 */
public class ParityBitAdder_v2 {
    /**
     * 验证输入的7位数据是否为二进制且长度正确。
     * @param dataBits 输入的7位数据字符串。
     * @throws NonBinaryValue 如果数据不是7位或包含非0/1字符。
     */
    public static void validateDataBits(String dataBits) throws NonBinaryValue{
        if (dataBits == null || dataBits.length() !=7 )
            throw new NonBinaryValue("错误：此程序的第一个输入必须是一个7位二进制数。请重试！");
        /*
         * 从 dataBits.toCharArray() 返回的字符数组中取出第一个字符。
            将这个字符的值赋给变量 c。
            执行 for 循环体内部的代码（花括号 {...} 之间的代码）。
            然后，自动从数组中取出第二个字符。
            将这个字符的值赋给变量 c。
            再次执行循环体内部的代码。
            这个过程会一直重复，直到数组中的所有字符都被遍历过一遍。
            当数组中没有更多元素时，循环结束。
         */
        for (char c : dataBits.toCharArray()){
            if (c != '0' && c != '1' ){
                throw new NonBinaryValue("错误：此程序的第一个输入必须是一个7位二进制数。请重试！");

            }
        }
    }
        /**
     * 验证输入的奇偶校验位是否为0或1。
     * @param parityBitArg 输入的奇偶校验位字符串。
     * @return 解析后的整数奇偶校验位 (0 或 1)。
     * @throws IllegalParityValue 如果奇偶校验位不是0或1。
     */
    public static int validateParityBit(String parityBitArg) throws IllegalParityValue {
        if (parityBitArg == null || (!parityBitArg.equals("0") && !parityBitArg.equals("1"))) {
            throw new IllegalParityValue("错误：程序的奇偶校验位输入（第二个参数）必须是0或1。请重试！");
        }
        return Integer.parseInt(parityBitArg);
    }

// 文件名: ParityBitAdder_v2.java
public class ParityBitAdder_v2 {

    /**
     * 验证输入的7位数据是否为二进制且长度正确。
     * @param dataBits 输入的7位数据字符串。
     * @throws NonBinaryValue 如果数据不是7位或包含非0/1字符。
     */
    public static void validateDataBits(String dataBits) throws NonBinaryValue {
        if (dataBits == null || dataBits.length() != 7) {
            throw new NonBinaryValue("错误：此程序的第一个输入必须是一个7位二进制数。请重试！");
        }
        for (char c : dataBits.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new NonBinaryValue("错误：此程序的第一个输入必须是一个7位二进制数。请重试！");
            }
        }
    }

    /**
     * 验证输入的奇偶校验位是否为0或1。
     * @param parityBitArg 输入的奇偶校验位字符串。
     * @return 解析后的整数奇偶校验位 (0 或 1)。
     * @throws IllegalParityValue 如果奇偶校验位不是0或1。
     */
    public static int validateParityBit(String parityBitArg) throws IllegalParityValue {
        if (parityBitArg == null || (!parityBitArg.equals("0") && !parityBitArg.equals("1"))) {
            throw new IllegalParityValue("错误：程序的奇偶校验位输入（第二个参数）必须是0或1。请重试！");
        }
        return Integer.parseInt(parityBitArg);
    }
    //第二步 其实这就像是继承了一个类 不过比较特殊
    //并不对  不是继承。这是一个声明，表明这个方法在执行过程中可能会创建一个 IllegalParityValue 类型的异常对象并将其“抛出”。这与继承是两个不同的概念

    /**
     * 计算给定数据位中的 '1' 的数量。
     * @param dataBits 二进制数据字符串。
     * @return '1' 的数量。
     */
    public static int countOnes(String dataBits) {
        int ones = 0;
        for (char c : dataBits.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        return ones;
    }


    /**
     * 主方法，程序的入口点。
     * @param args 命令行参数。期望有两个参数:
     *             args[0] - 一个7位的二进制字符串。
     *             args[1] - 一个整数，0 表示偶校验 even ，1 表示奇校验 odd
     */
    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("Error: Two arguments required (7-bit binary number and parity type 0 or 1).");
            System.out.println("Usage: java ParityBitAdder <7-bit binary string> <0|1>");
            System.exit(1);// 非正常退出
        }
        String dataBits = args[0];
        String parityBitArg = args[1];



        //2025年6月6日14:31:05 重头戏 之前没用过的
        try {
             validateDataBits(dataBits);
             int chosenParityType = validateParityBit(parityBitArg);
            //第三步 就是把刚刚创建出来的调了出来 也就是把检测给开启了


            // 3. 计算奇偶校验位
            int ones = countOnes(dataBits);
            char parityBitToAdd;

            // chosenParityType = 0 (偶校验): 总1的个数应为偶数
            // chosenParityType = 1 (奇校验): 总1的个数应为奇数
            if (chosenParityType == 0) { // 偶校验
                if (ones % 2 == 0) {
                    parityBitToAdd = '0'; // 数据中1为偶数，加0保持偶数
                } else {
                    parityBitToAdd = '1'; // 数据中1为奇数，加1变成偶数
                }
            } else { // 奇校验 (chosenParityType == 1)
                if (ones % 2 == 0) {
                    parityBitToAdd = '1'; // 数据中1为偶数，加1变成奇数
                } else {
                    parityBitToAdd = '0'; // 数据中1为奇数，加0保持奇数
                }
            }

            // 4. 输出结果
            System.out.println("原始数据: " + dataBits);
            System.out.println("选择的奇偶校验类型: " + (chosenParityType == 0 ? "偶校验" : "奇校验"));
            System.out.println("计算出的奇偶校验位: " + parityBitToAdd);
            System.out.println("带奇偶校验位的数据: " + dataBits + parityBitToAdd);

        } 
        catch (NonBinaryValue e) {
            // 第一个 catch 块
            // 这个块专门用来捕获 NonBinaryValue 类型的异常
            // 如果 try 块中的 validateDataBits(dataBits) 抛出了 NonBinaryValue 异常，
            // 程序会立即跳转到这里执行。
            System.err.println(e.getMessage());
            // 打印 NonBinaryValue 异常对象中存储的错误消息

            //那我就有两个疑问 throw new NonBinaryValue上面写方法的时候有两个 怎么知道打印哪一个
            //————在一个方法的单次调用中，只有一个 throw 语句会被执行，因为 throw 会立即中断方法的执行
            //另外就是 不是已经有throw了吗 为什么还要println
            //—— 飞书说
        }
        catch (IllegalParityValue e ){
            //这个e有什么特别的 没有特别的啊 参数
            System.err.println(e.getMessage());
            //其实这种写法也算是有点多余吧
        }


/* 
        // 2. 输入验证：检查7位二进制数格式
        if (sevenBitPattern.length() != 7) {
            System.out.println("Error: The first argument must be a 7-bit binary string.");
            System.exit(1);
        }
        for (int i = 0; i < sevenBitPattern.length(); i++) {
            char c = sevenBitPattern.charAt(i);
            if (c != '0' && c != '1') {
                System.out.println("Error: Binary string can only contain '0' or '1');");
                System.exit(1);
            }
        }
       
        // 3. 输入验证：检查校验类型
        if(!parityTypeStr.equals("0") && !parityTypeStr.equals("1")){
            System.out.println("Error: The second argument (parity type) must be 0 (even parity) or 1 (odd parity).");
            System.exit(1);
        }
*/
        parityType = Integer.parseInt(parityTypeStr);// 此时可以安全转换，因为已验证是 "0" 或 "1"

        // 4. 调用 calculateParity 方法计算结果
        String result = calculateParity(sevenBitPattern, parityType);

        // 5. 输出结果
        String parityDescription = (parityType == 0) ? "even" : "odd";
        System.out.println("Result of adding " + parityDescription + " parity to '" + sevenBitPattern + "' is binary pattern '" + result + "'.");

    }
    /**
     * 计算并添加奇偶校验位到给定的7位二进制模式。
     *
     * @param sevenBitPattern 7位二进制字符串。
     * @param parityType      校验类型 (0 表示偶校验, 1 表示奇校验)。
     * @return 包含校验位的8位二进制字符串。
     */

    public static String calculateParity(String sevenBitPattern, int parityType){
        //比如像这里我不写static会发生什么 _ 那么这个方法就变成了一个 实例方法 (instance method)，而不是 静态方法 (static method)
        //就是静态方法没法访问刚创的实例相关呗
        int onesCount = countOnes(sevenBitPattern); // 计算7位串中1的个数
        char parityBit;
        if (parityType == 0) { // 偶校验
            // 目标：使得8位串中1的个数为偶数
            if (onesCount % 2 == 0) { // 如果7位串中1的个数已经是偶数
                parityBit = '0';      // 添加0，1的个数不变，仍为偶数
            } else {                  // 如果7位串中1的个数是奇数
                parityBit = '1';      // 添加1，1的个数变为偶数
            }
        } else { // 奇校验 (parityType == 1)
            // 目标：使得8位串中1的个数为奇数
            if (onesCount % 2 == 0) { // 如果7位串中1的个数是偶数
                parityBit = '1';      // 添加1，1的个数变为奇数
            } else {                  // 如果7位串中1的个数是奇数
                parityBit = '0';      // 添加0，1的个数不变，仍为奇数
            }
        }
        // 将校验位添加到7位模式的前面
        //这是什么用法 直接加？—— + 操作符的用法是 字符串拼接 (String Concatenation)
        return parityBit + sevenBitPattern;

    }


        /**
     * 计算给定二进制字符串中 '1' 的数量。
     *
     * @param binaryString 一个只包含 '0' 和 '1' 的字符串。
     * @return 字符串中 '1' 的数量。
     */
    private static int countOnes(String binaryString) {
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
