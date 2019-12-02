package Commands;

import logic.Game;

public class UpdateCommand extends Commands {

	public UpdateCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {
		game.update();
		return true;
	}

	@Override
	public Commands parse(String[] commandWord) {
		if(commandWord.length != 1) return null;
		else if (commandWord[0].equalsIgnoreCase("update") || commandWord[0].equalsIgnoreCase("u")) {
			return new UpdateCommand("Update", "U", "", "Game Updated.");
		}
		else {
			return null;
		}
	}

}
