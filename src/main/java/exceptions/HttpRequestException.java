package exceptions;

public class HttpRequestException extends Exception {
    public HttpRequestException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
