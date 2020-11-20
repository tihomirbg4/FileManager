public class TooManyArgumentsException extends Throwable {
    private String message;

    public TooManyArgumentsException(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
