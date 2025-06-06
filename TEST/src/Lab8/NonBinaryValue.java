package Lab8;
// 文件名: NonBinaryValue.java
/**
 * 当提供的值不是预期的二进制格式或长度时抛出此异常。
 */

public class NonBinaryValue extends Exception{
        /**
     * 构造一个新的 NonBinaryValue 异常，并带有指定的详细消息。
     * @param message 详细消息。
     */
    public NonBinaryValue(String message){
        super(message);
    }
    //应该就是只有这个功能：Exception 类（及其父类 Throwable）会负责存储这个 message 字符串，并提供一个 getMessage() 方法来获取它。
}
