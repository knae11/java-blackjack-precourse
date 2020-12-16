package domain.common;

public class ErrorMessageException extends IllegalArgumentException{
    private static final String ERR0R = "[ERROR] ";
    public ErrorMessageException(String message){
        super(ERR0R+ message);
    }
}
