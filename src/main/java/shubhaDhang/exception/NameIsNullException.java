package shubhaDhang.exception;

public class NameIsNullException extends RuntimeException {
    public NameIsNullException(String message) {
        super(message);
    }

    public NameIsNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
