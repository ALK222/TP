package exceptions;

public class MoveParseException extends CommandParseException {

	public MoveParseException (String msg){
		super("move <right|left> <1|2>" + msg);
	}
	
}
