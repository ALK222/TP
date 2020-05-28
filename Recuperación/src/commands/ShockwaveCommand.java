package commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class ShockwaveCommand extends Command {

	public ShockwaveCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	public boolean execute(Game game) throws CommandExecuteException {
		if (!game.shockWave()) {
			throw new CommandExecuteException("Shockwave not available");
		}
		return true;
	}

	public Command parse(String[] commandWord) throws CommandParseException {
		if (!matchCommandName(commandWord[0])) {
			return null;
		} else if (commandWord.length != 1) {
			throw new CommandParseException(Command.incorrectNumArgsMsg);
		}
		return new ShockwaveCommand(name, shortcut, details, help);
	}

}
