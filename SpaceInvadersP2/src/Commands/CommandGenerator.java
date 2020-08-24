package commands;

import exceptions.CommandMovementException;
import exceptions.CommandParseException;

public class CommandGenerator {

	private static Command[] availableCommands = {
			// List of all commands
			new ListCommand(), new HelpCommand(), new ResetCommand(), new ExitCommand(), new UpdateCommand(),
			new MoveCommand(), new ShockwaveCommand(), new SaveCommand(), new ShootCommand(), new BuyCommand(),
			new StringifyCommand() };

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
		// parse commands
		int i = 0;
		boolean ok = false;
		try {
			while (!ok && i < availableCommands.length) {
				if (availableCommands[i].parse(commandWords) == null) {
					i++;
				} else {
					return availableCommands[i].parse(commandWords);
				}
			}
			if (!ok) {
				throw new CommandMovementException(Command.incorrectArgsMsg);
			}
		} catch (CommandParseException | CommandMovementException ex) {
			throw ex;
		}
		return null;
	}

}
