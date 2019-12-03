package exceptions;

@SuppressWarnings("serial")

public class CommandExecuteException extends Exception{
	public CommandExecuteException(String mesg) {
		super("Execution Command Failed" + mesg);
	}
}
