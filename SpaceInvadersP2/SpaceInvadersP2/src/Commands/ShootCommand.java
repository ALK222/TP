package Commands;

import exceptions.CommandParseException;
import logic.Game;

public class ShootCommand extends Commands{
	String supermisile;

	public ShootCommand(String name, String shortcut, String details, String help, String supermisile) {
		super(name, shortcut, details, help);
		this.supermisile = supermisile;
	}

	
	public boolean execute(Game game) {
		game.shootLaser(this.supermisile);
		return false;
	}

	public Commands parse(String[] commandWord) throws CommandParseException {
		Commands result = null;
		if(commandWord[0].equalsIgnoreCase(name) || commandWord[0].equalsIgnoreCase(shortcut)) {
			if(commandWord.length > 1 ) {
				if(commandWord[1].equals("supermisil")) {
					result = new ShootCommand("Shoot", "B", "", "", commandWord[1]);
				} else {
					throw new CommandParseException("There was a problem with supermisil\n");
				}
			} 
			else {
				result = new ShootCommand("Shoot", "B", "", "", null);
			}
		}
		return result; 
		
	}
}
