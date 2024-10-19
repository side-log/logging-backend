package yeah.yeahlogging.config.exception;

public class InvalidLogTypeException extends IllegalArgumentException {
    public InvalidLogTypeException() {}

    public InvalidLogTypeException(String message) {
        super(message);
    }

    public InvalidLogTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLogTypeException(Throwable cause) {
        super(cause);
    }
}
