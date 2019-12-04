package Commands;

import logic.Game;

public class ShootCommand extends Commands{
	public ShootCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	
	public boolean execute(Game game) {
		if(this.details == null) {
			if(game.shootLaser()) {
				return true;
			}
		}
		else {
			if(game.shootSuperLaser()) {
				return true;
			}
		}
		return false;
	}

	
	public Commands parse(String[] commandWords) {
		if(commandWords.length != 1 || commandWords.length != 2) {
			System.out.print(Commands.incorrectNumArgsMsg);
			return null;
		}
		else if (commandWords[0].equalsIgnoreCase("shoot") || commandWords[0].equalsIgnoreCase("s")) {
			return new ExitCommand("Shoot", "s", commandWords[1], "Exit: Ends the program.");
		}
		else {
			return null;
		}
	}

}
