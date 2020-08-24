package commands;

import exceptions.CommandParseException;
import logic.Game;

public class ListCommand extends Command {

	private static String _name = "List";

	private static String _shortcut = "L";

	private static String _details = "Shows information about the current game";

	private static String _help = "Shows information about the current game";

	// CONSTRUCTOR
	public ListCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	public ListCommand() {
		super(_name, _shortcut, _details, _help);
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
