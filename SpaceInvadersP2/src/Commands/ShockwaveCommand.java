package commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class ShockwaveCommand extends Command {

	private static String _name = "ShockWave";
	private static String _shortcut = "W";
	private static String _details = "Deals 1 damage to all enemy ships on the board";
	private static String _help = "Kill one (1) ovni to get the habillity to shot the ShockWave";

	public ShockwaveCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	public ShockwaveCommand() {
		super(_name, _shortcut, _details, _help);
	}

	public boolean execute(Game game) throws CommandExecuteException {
		try {
			game.shockWave();
		} catch (Exception e) {
			throw e;
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
