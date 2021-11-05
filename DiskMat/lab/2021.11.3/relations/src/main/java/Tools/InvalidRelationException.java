package Tools;

public class InvalidRelationException extends RuntimeException
{
    private final String message;

    @Override
    public String getMessage()
    {
        return this.message;
    }

    public InvalidRelationException(String message)
    {
        this.message = message;
    }
}
