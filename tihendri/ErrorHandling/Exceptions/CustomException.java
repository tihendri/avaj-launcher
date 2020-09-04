package tihendri.ErrorHandling.Exceptions;

public class CustomException extends RuntimeException {

    public CustomException(String logMessage) {
        super(logMessage);
    }
}