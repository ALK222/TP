package commands;

import exceptions.CommandParseException;
import logic.Game;

public class UpdateCommand extends Command {

	public UpdateCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
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
