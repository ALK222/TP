package Commands;

import logic.Game;

public class ListCommand extends Commands{

	
	//CONSTRUCTOR
	public ListCommand (String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	
	public boolean execute(Game game) {
		System.out.println(game.infoToString());
		return false;
	}

	
	public Commands parse(String[] commandWord) {
		if(commandWord.length != 1) {
			System.out.print(Commands.incorrectNumArgsMsg);
			return null;
		}
		else if (commandWord[0].equalsIgnoreCase("list") || commandWord[0].equalsIgnoreCase("l")) {
			return new ListCommand("List", "L", "", "Game List:");
		}
		else {
			return null;
		}
	}
	
}
