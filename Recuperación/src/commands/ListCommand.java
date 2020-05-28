package commands;

import exceptions.CommandParseException;
import logic.Game;

public class ListCommand extends Command {

	// CONSTRUCTOR
	public ListCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	public boolean execute(Game game) {
		System.out.println(game.infoToString());
		return false;
	}

	public Command parse(String[] commandWord) throws CommandParseException {
		if (!matchCommandName(commandWord[0])) {
			return null;
		} else if (commandWord.length != 1) {
			throw new CommandParseException(Command.incorrectNumArgsMsg);
		}
		return new ListCommand(name, shortcut, details, help);
	}

}
