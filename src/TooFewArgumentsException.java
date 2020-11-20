public class TooFewArgumentsException extends Throwable {
    private String message;

    public TooFewArgumentsException(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
