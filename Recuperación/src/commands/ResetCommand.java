package commands;

import exceptions.CommandParseException;
import logic.Game;

public class ResetCommand extends Command {

	public ResetCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	public boolean execute(Game game) {
		game.initGame();
		return false;
	}

	public Command parse(String[] commandWord) throws CommandParseException {
		if (!matchCommandName(commandWord[0])) {
			return null;
		} else if (commandWord.length != 1) {
			throw new CommandParseException(Command.incorrectNumArgsMsg);
		}
		return new ResetCommand(name, shortcut, details, help);
	}
}
