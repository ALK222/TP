package commands;

import exceptions.CommandMovementException;
import exceptions.CommandParseException;

public class CommandGenerator {

	private static Command[] availableCommands = {
			// List of all commands
			new ListCommand("List", "L", "", "shows information of the game"),
			new HelpCommand("Help", "H", "", " shows help"),
			new ResetCommand("Reset", "R", "", "resets the game"),
			new ExitCommand("Exit", "E", "", "exits the game"),
			new UpdateCommand("Update", "U", "", "updates the game, leaving the command completely blank will have the same effect"),
			new MoveCommand("Move", "m", "", "moves the ship", "", "0"),
			new ShockwaveCommand("ShockWave", "W", "", "deals 1 damage to all ships on the board and destroys enemy bullets"),
			new SaveCommand("Save", "S", "", "saves the current state of the game", ""),
			new ShootCommand("Shoot", "F", "", "shots a laser, if you put supermisil in the command shoots a supermisille",
					""),
			new BuyCommand("Buy", "B", "", "Buy: buys a supermisille for 20 points"),
			new StringifyCommand("Stringify", "C", "", "Stringify: changes the game perspective") };

	public static String commandHelp() {
		// shows al commands
		String show = "The available commands are:" + System.getProperty("line.separator");

		for (int i = 0; i < availableCommands.length; i++) {
			show += availableCommands[i].helpText();
			show += System.getProperty("line.separator");
		}
		return show;
	}

	public static Command parseCommand(String[] commandWords) throws CommandParseException, CommandMovementException {
		//parse commands
		int i = 0;
		boolean ok = false;
		try {
			while (!ok && i<availableCommands.length) {
				if (availableCommands[i].parse(commandWords) == null) {
					i++;
				}
				else {
					return availableCommands[i].parse(commandWords);
				}
			}
			if(!ok){
				throw new CommandMovementException(Command.incorrectArgsMsg);
			}
		} catch (CommandParseException | CommandMovementException ex) {
			throw ex;
		}
		return null;
	}


	
}
