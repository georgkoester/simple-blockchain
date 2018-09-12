package chain;


public class InvalidNewBlockException extends Throwable
{
    public InvalidNewBlockException()
    {
    }

    public InvalidNewBlockException( String message )
    {
        super(message);
    }
}
