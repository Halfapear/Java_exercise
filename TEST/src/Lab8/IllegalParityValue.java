package Lab8;

// 文件名: IllegalParityValue.java
/**
 * 当提供的奇偶校验位值不是0或1时抛出此异常。
 */
public class IllegalParityValue extends Exception {
    /**
     * 构造一个新的 IllegalParityValue 异常，并带有指定的详细消息。
     * @param message 详细消息。
     */
    public IllegalParityValue(String message) {
        super(message);
    }
}