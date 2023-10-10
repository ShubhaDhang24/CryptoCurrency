package shubhaDhang.exception;

public class NameException extends RuntimeException {
    public NameException(String message) {
        super(message);
    }

    public NameException(String message, Throwable cause) {
        super(message, cause);
    }
}
