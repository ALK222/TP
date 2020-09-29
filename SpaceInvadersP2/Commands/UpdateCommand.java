package commands;

import exceptions.CommandParseException;
import logic.Game;

public class UpdateCommand extends Command {

	private static String _name = "Update";
	private static String _shortcut = "U";
	private static String _details = "Updates the game one (1) cycle";
	private static String _help = "Leaving the command completely blank will have the same effect";

	public UpdateCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	public UpdateCommand() {
		super(_name, _shortcut, _details, _help);
	}

	public boolean execute(Game game) {
		return true;
	}

	public Command parse(String[] commandWord) throws CommandParseException {
		if (!commandWord[0].equals("")) {
			if (!matchCommandName(commandWord[0])) {
				return null;
			}
		} else if (commandWord.length != 1) {
			throw new CommandParseException(Command.incorrectNumArgsMsg);
		}
		return new UpdateCommand(name, shortcut, details, help);
	}

}
