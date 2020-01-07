package exceptions;

public class CommandParseException extends Exception{
    
    private static final long serialVersionUID = 2L;

    public CommandParseException(String msg){
        super("Parse problem: " + msg);
    }

}