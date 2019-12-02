package Commands;

import logic.Game;

public class ShockwaveCommand extends Commands{

	public ShockwaveCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	
	public boolean execute(Game game) {
		game.enableShockWave();
		return true;
	}

	
	public Commands parse(String[] commandWord) {
		if(commandWord.length != 1) {
			System.out.print(Commands.incorrectNumArgsMsg);
			return null;
		}
		else if (commandWord[0].equalsIgnoreCase("shockwave") || commandWord[0].equalsIgnoreCase("w")) {
			return new ShockwaveCommand("Shockwave", "W", "", "ShockWave Enabled.");
		}
		else {
			return null;
		}
	}

}
