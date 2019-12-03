package Commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class SaveCommand extends Commands{
	
	private String filename;
	
	public SaveCommand (String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	
	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		game.saveState(this.filename);
		return true;
	}

	@Override
	public Commands parse(String[] commandWord) throws CommandParseException{

		if(commandWord.length != 1) return null;
		else if (commandWord[0].equalsIgnoreCase("reset") || commandWord[0].equalsIgnoreCase("r")) {
			return new ResetCommand("Reset", "R", "", "Reset: Resets the program.");
		}
		else {
			return null;
		}
	}
}
