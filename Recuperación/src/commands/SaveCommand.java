package commands;

import java.io.IOException;

import exceptions.CommandParseException;
import logic.Game;

public class SaveCommand extends Command {

	private String filename;

	public SaveCommand(String name, String shortcut, String details, String help, String filename) {
		super(name, shortcut, details, help);
		this.filename = filename;
	}

	public boolean execute(Game game) throws IOException {
		game.saveState(filename);
		return false;
	}

	public Command parse(String[] commandWord) throws CommandParseException {
		if (!matchCommandName(commandWord[0])) {
			return null;
		} else if (commandWord.length != 2) {
			throw new CommandParseException("Please enter a filename");
		}
		return new SaveCommand(name, shortcut, details, help, commandWord[1]);
	}
}
