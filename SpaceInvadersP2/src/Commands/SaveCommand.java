package commands;

import java.io.IOException;

import exceptions.CommandParseException;
import logic.Game;

public class SaveCommand extends Command {

	private static String _name = "Save";
	private static String _shortcut = "S";
	private static String _details = "Saves the current state of the game";
	private static String _help = "You must introduce a filename in order to save the game";

	private String filename;

	public SaveCommand(String name, String shortcut, String details, String help, String filename) {
		super(name, shortcut, details, help);
		this.filename = filename;
	}

	public SaveCommand() {
		super(_name, _shortcut, _details, _help);
	}

	public boolean execute(Game game) throws IOException {
		try {
			game.saveState(filename);
		} catch (Exception e) {
			throw e;
		}
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
