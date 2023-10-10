package shubhaDhang.exception;

public class AmountNegativeException extends RuntimeException {

    public AmountNegativeException(String message) {
        super(message);
    }
    public AmountNegativeException(String message, Throwable cause) {
        super(message, cause);

    }
}
