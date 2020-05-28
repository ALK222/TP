package commands;

import exceptions.CommandParseException;
import logic.Game;

public class StringifyCommand extends Command {
	public StringifyCommand(String name, String shortcut, String details2, String help) {
		super(name, shortcut, details2, help);
	}

	public boolean execute(Game game) {
		if (game.getPrinterOption() == 'b') {
			game.setPrinterOption('s');
		} else {
			game.setPrinterOption('b');
		}
		return false;
	}

	public Command parse(String[] commandWord) throws CommandParseException {
		if (!matchCommandName(commandWord[0])) {
			return null;
		} else if (commandWord.length != 1) {
			throw new CommandParseException(Command.incorrectNumArgsMsg);
		}
		return new StringifyCommand(name, shortcut, details, help);
	}

}
