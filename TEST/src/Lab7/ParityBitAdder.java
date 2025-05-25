//package Lab7;
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
public class ParityBitAdder {
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
        String sevenBitPattern = args[0];
        String parityTypeStr = args[1];
        int parityType;

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
