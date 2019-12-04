package Commands;

import exceptions.CommandParseException;
import logic.Game;

public class ShootCommand extends Commands{
	String supermisile = null;

	public ShootCommand() {
		super("Shoot", "B", "", "");
	}

	
	public boolean execute(Game game) {
		game.shootLaser();
		return false;
	}

	public Commands parse(String[] commandWord) throws CommandParseException {
		Commands result = null;
		if(commandWord[0].equalsIgnoreCase(name) || commandWord[0].equalsIgnoreCase(shortcut)) {
			if(commandWord.length > 1 ) {
				if(commandWord[1].equals("supermisil")) {
					supermisile = commandWord[1];
					result = new ShootCommand();
				} else {
					throw new CommandParseException("There was a problem with supermisil");
				}
			} 
		}
		return result; 
		
	}
}
