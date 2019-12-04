package Commands;

import exceptions.MoveParseException;
import logic.Game;

public class MoveCommand extends Commands{
	
	String dir = null;
	int vel = 0;

	public MoveCommand() {
		super("Move", "M", " ", " ");
	}

	
	public boolean execute(Game game) {

		game.move(dir, vel);


		return true;
	}

	public Commands parse(String[] commandWord) throws MoveParseException {
		Commands result = null;
		if(commandWord[0].equalsIgnoreCase(name) || commandWord[0].equalsIgnoreCase(shortcut)) {
			if(commandWord.length > 3 ) {
				if(commandWord[1].equals("right") || commandWord[1].equals("left")) {
					dir = commandWord[1];
					if(commandWord[2].equals("1") || commandWord[2].equals("2")) {
						vel = Integer.parseInt(commandWord[2]);
						result = new MoveCommand();
					}
					else {
						throw new MoveParseException("Wrong speed number");
					}
				} else {
					throw new MoveParseException("Direction not right");
				}
			} else {
				throw new MoveParseException("More arguments are needed");
			}
		} 
		
		return result;
	}

}
