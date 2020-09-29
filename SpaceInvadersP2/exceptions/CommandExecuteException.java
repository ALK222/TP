package exceptions;

public class CommandExecuteException extends Exception {

    private static final long serialVersionUID = 2L;

    public CommandExecuteException(String msg) {
        super("Execute problem: " + msg);
    }

}
