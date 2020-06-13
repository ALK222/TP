package commands;

import exceptions.CommandParseException;
import logic.Game;

public class HelpCommand extends Command {

	private static String _name = "Help";
	private static String _shortcut = "H";
	private static String _details = "Shows help";
	private static String _help = "Shows help";

	// CONSTRUCTOR
	public HelpCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	public HelpCommand() {
		super(_name, _shortcut, _details, _help);
	}

	public boolean execute(Game game) {
		System.out.print(CommandGenerator.commandHelp());
		return false;
	}

	public Command parse(String[] commandWord) throws CommandParseException {
		if (!matchCommandName(commandWord[0])) {
			return null;
		} else if (commandWord.length != 1) {
			throw new CommandParseException(Command.incorrectNumArgsMsg);
		}
		return new HelpCommand(name, shortcut, details, help);
	}
}
