package Commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class SaveCommand extends Commands{
	
	private String filename;
	
	public SaveCommand (String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	
	
	public boolean execute(Game game) throws CommandExecuteException{
		game.saveState(this.filename);
		return false;
	}

	
	public Commands parse(String[] commandWord) throws CommandParseException{

		if(commandWord.length != 1) return null;
		else if (commandWord[0].equalsIgnoreCase("save") || commandWord[0].equalsIgnoreCase("s")) {
			return new SaveCommand("Save", "s", "", "Save: saves the state of the game.");
		}
		else {
			return null;
		}
	}
}
