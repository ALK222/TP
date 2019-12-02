package Commands;

import logic.Game;

public class ResetCommand extends Commands {
	
	public ResetCommand (String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {
		game.reset();
		return true;
	}

	@Override
	public Commands parse(String[] commandWord) {

		if(commandWord.length != 1) return null;
		else if (commandWord[0].equalsIgnoreCase("reset") || commandWord[0].equalsIgnoreCase("r")) {
			return new ResetCommand("Reset", "R", "", "Reset: Resets the program.");
		}
		else {
			return null;
		}
	}
}
