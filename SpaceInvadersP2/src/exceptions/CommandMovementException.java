package exceptions;

public final class CommandMovementException extends Exception {

    private static final long serialVersionUID = 6663286790176942019L;

    public CommandMovementException(String msg) {
        super("Hey listen! " + msg);
    }

}