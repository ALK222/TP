package commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class ShootCommand extends Command {

	private static String _name = "Shoot";
	private static String _shortcut = "F";
	private static String _details = "Shots a laser";
	private static String _help = "shots a laser, if you put supermisil in the command shoots a supermisille";
	private String supermisile;

	public ShootCommand(String name, String shortcut, String details, String help, String supermisile) {
		super(name, shortcut, details, help);
		this.supermisile = supermisile;
	}

	public ShootCommand() {
		super(_name, _shortcut, _details, _help);
	}

	public boolean execute(Game game) throws CommandExecuteException {
		try {
			game.shootLaser(this.supermisile);
		} catch (Exception e) {
			throw e;
		}
		return true;
	}

	public Command parse(String[] commandWord) throws CommandParseException {
		if (!matchCommandName(commandWord[0])) {
			return null;
		} else if (commandWord.length != 1) {
			if (commandWord.length != 2) {
				throw new CommandParseException(Command.incorrectArgsMsg);
			}
		}
		if (commandWord.length == 2 && commandWord[1].equals("supermisil")) {
			return new ShootCommand(name, shortcut, details, help, commandWord[1]);
		} else if (commandWord.length == 2 && !commandWord[1].equals("supermisil")) {
			throw new CommandParseException("Incorrect type of missil, type supermisil or leave it blank");
		}
		return new ShootCommand(name, shortcut, details, help, null);

	}
}
