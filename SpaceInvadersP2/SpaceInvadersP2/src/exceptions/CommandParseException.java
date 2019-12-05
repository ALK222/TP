package exceptions;

@SuppressWarnings("serial")

public class CommandParseException extends Exception{
	
	public CommandParseException(String mesg) {
		super("Problem parse exception"+mesg);
	}
}

