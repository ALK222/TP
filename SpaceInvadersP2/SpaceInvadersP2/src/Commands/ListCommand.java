package Commands;

import logic.Game;

public class ListCommand extends Commands{

	
	//CONSTRUCTOR
	public ListCommand (String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {
		game.infoToString();
		return true;
	}

	@Override
	public Commands parse(String[] commandWord) {
		if(commandWord.length != 1) return null;
		else if (commandWord[0].equalsIgnoreCase("list") || commandWord[0].equalsIgnoreCase("l")) {
			return new ListCommand("List", "L", "", "Game List:");
		}
		else {
			return null;
		}
	}
	
}
