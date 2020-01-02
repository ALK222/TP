package Commands;

import java.io.IOException;

import exceptions.CommandExecuteException;
import logic.Game;

public class SaveCommand extends Commands{
	
	private String filename;
	
	public SaveCommand (String name, String shortcut, String details, String help, String filename) {
		super(name, shortcut, details, help);
		this.filename = filename;
	}

	
	
	public boolean execute(Game game) throws CommandExecuteException{
		try {
			game.saveState(this.filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public Commands parse(String[] commandWord){

		if(commandWord.length != 2) return null;
		else if (commandWord[0].equalsIgnoreCase("save") || commandWord[0].equalsIgnoreCase("s")) {
			return new SaveCommand("Save", "s", "", "Save: saves the state of the game.", commandWord[1]);
		}
		else {
			return null;
		}
	}
}
