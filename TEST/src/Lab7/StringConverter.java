/*
 * javac StringConverter.java
 * java StringConverter "My car Goes verY FAST!"
 * Output: My*CaR*GoeS*VeRy*FaST*
 */

//package Lab7;

public class StringConverter {
        /**
     * 主方法，程序的入口点。
     * @param args 命令行参数。期望有一个参数:
     *             args[0] - 要转换的输入字符串。
     */
    public static void main(String[] args){
        // 1. 输入验证：检查参数数量
        if (args.length != 1) {
            System.out.println("Error: One string argument is required.");
            System.out.println("Usage: java StringConverter \"<input string>\"");
            System.exit(1);
        }

        String inputString = args[0];
        String convertedString = convertString(inputString);
        // 输出结果
        System.out.println("Output: " + convertedString);

    }

    /**
     * 根据指定规则转换字符串。
     * 元音 (a, e, i, o, u, y) -> 小写
     * 辅音 -> 大写
     * 非字母 -> *
     * @param originalString 原始输入字符串。
     * @return 转换后的字符串。
     */
    public static String convertString(String originalString) {
        // 1. 创建一个 StringBuilder 对象，命名为 sb。
        //    StringBuilder 用于高效地构建和修改字符串。
        //    与 String 不同，StringBuilder 的内容是可变的，
        //    在循环中追加字符时，它通常比 String 的 `+` 拼接更有效率，
        //    因为它避免了每次都创建新的 String 对象。
        StringBuilder sb = new StringBuilder();

        // 2. 使用 for 循环遍历输入字符串 `originalString` 中的每一个字符。
        //    `i` 是循环变量，代表当前字符的索引，从 0 开始，直到字符串长度减 1。
        for (int i = 0; i < originalString.length(); i++) {
            // 3. 获取 `originalString` 中索引为 `i` 的字符，并将其存储在 `currentChar` 变量中。
            char currentChar = originalString.charAt(i);

            // 4. 声明一个字符变量 `processedChar`，用于存储处理后的字符。
            //    这个字符将是根据规则转换后的结果。
            char processedChar;

            // 5. 使用 `Character.isLetter(currentChar)` 判断 `currentChar` 是否是一个字母。
            if (Character.isLetter(currentChar)) {
                // 5a. 如果 `currentChar` 是一个字母：
                //     接着调用 `isVowel(currentChar)` 方法 (这个方法在类的其他地方定义)
                //     来判断这个字母是否是元音 (a, e, i, o, u, y，不区分大小写)。
                if (isVowel(currentChar)) {
                    // 5a.i. 如果是元音字母：
                    //        使用 `Character.toLowerCase(currentChar)` 将其转换为小写，
                    //        并将结果赋给 `processedChar`。
                    processedChar = Character.toLowerCase(currentChar);
                } else {
                    // 5a.ii. 如果是辅音字母 (即不是元音的字母)：
                    //         使用 `Character.toUpperCase(currentChar)` 将其转换为大写，
                    //         并将结果赋给 `processedChar`。
                    processedChar = Character.toUpperCase(currentChar);
                }
            } else {
                // 5b. 如果 `currentChar` 不是一个字母 (例如数字、符号、空格等)：
                //     将 `processedChar` 设置为星号字符 '*'。
                processedChar = '*';
            }

            // 6. 将处理得到的 `processedChar` 追加到 `StringBuilder` 对象 `sb` 的末尾。
            //    `sb.append()` 方法会修改 `sb` 内部的字符序列。
            sb.append(processedChar);
        }

        // 7. 循环结束后，`sb` 中就包含了所有字符按规则转换后的完整序列。
        //    调用 `sb.toString()` 方法将 `StringBuilder` 对象的内容转换为一个标准的、不可变的 `String` 对象。
        //    这个新的 `String` 对象就是最终的转换结果。
        return sb.toString();
    }

    /**
     * 检查一个字符是否是元音 (a, e, i, o, u, y)，并且这个检查是不区分大小写的。
     * 例如，'A' 和 'a' 都会被认为是元音。
     *
     * @param c 要被检查的字符。
     * @return 如果传入的字符 `c` 是元音 (a, e, i, o, u, y 中的任意一个，不区分大小写)，
     *         则返回布尔值 `true`；否则返回 `false`。
     */
    private static boolean isVowel(char c) {
        // 1. 将传入的字符 `c` 转换为其对应的小写形式，并将结果存储在新的字符变量 `lowerC` 中。
        //    `Character.toLowerCase(c)` 是 Java Character 类的一个静态方法，
        //    它接收一个字符作为参数，如果该字符是大写字母，则返回其小写形式；
        //    如果该字符已经是小写字母或不是字母，则通常返回原字符。
        //    这样做是为了简化后续的比较逻辑，我们只需要和一组小写元音字符比较即可，
        //    而不需要同时检查大写和小写两种情况 (例如 `c == 'a' || c == 'A'`)。
        char lowerC = Character.toLowerCase(c);

        // 2. 进行一系列的或 (OR, `||`) 逻辑比较。
        //    这个 `return` 语句会直接返回整个布尔表达式的结果。
        //    表达式的含义是：如果 `lowerC` 等于 'a'，或者 `lowerC` 等于 'e'，
        //    或者 `lowerC` 等于 'i'，或者 `lowerC` 等于 'o'，
        //    或者 `lowerC` 等于 'u'，或者 `lowerC` 等于 'y'，
        //    那么整个表达式的结果就是 `true`。
        //    只要其中任何一个条件满足 (`true`)，由于是 `||` (或) 操作，整个表达式就会是 `true`。
        //    只有当 `lowerC` 不等于上述任何一个小写元音字母时，所有条件都为 `false`，
        //    整个表达式的结果才会是 `false`。
        return lowerC == 'a' || lowerC == 'e' || lowerC == 'i' || lowerC == 'o' || lowerC == 'u' || lowerC == 'y';
    }



}
