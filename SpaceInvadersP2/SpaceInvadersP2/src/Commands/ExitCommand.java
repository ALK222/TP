package Commands;

import logic.Game;

public class ExitCommand extends Commands{

	public ExitCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {
		game.exit();
		return true;
	}

	@Override
	public Commands parse(String[] commandWords) {
		if(commandWords.length != 1) return null;
		else if (commandWords[0].equalsIgnoreCase("exit") || commandWords[0].equalsIgnoreCase("e")) {
			return new ExitCommand("Exit", "E", "", "Exit: Ends the program.");
		}
		else {
			return null;
		}
	}

}
