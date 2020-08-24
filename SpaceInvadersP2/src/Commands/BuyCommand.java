package commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class BuyCommand extends Command {

	private static String _name = "Buy";
	private static String _shortcut = "B";
	private static String _details = "Buys a supermisille";
	private static String _help = "A supermisille costs 20 points. Kill enemy ships to earn points";

	public BuyCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	public BuyCommand() {
		super(_name, _shortcut, _details, _help);
	}

	public boolean execute(Game game) throws CommandExecuteException {
		try {
			game.buy();
		} catch (Exception e) {
			throw e;
		}
		return false;
	}

	public Command parse(String[] commandWord) throws CommandParseException {
		if (!matchCommandName(commandWord[0])) {
			return null;
		} else if (commandWord.length != 1) {
			throw new CommandParseException(Command.incorrectNumArgsMsg);
		}
		return new BuyCommand(name, shortcut, details, help);
	}

}
