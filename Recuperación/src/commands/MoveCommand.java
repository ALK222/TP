package commands;

import exceptions.CommandExecuteException;
import exceptions.CommandMovementException;
import exceptions.CommandParseException;
import logic.Game;

public class MoveCommand extends Command {

	String dir;
	int vel;

	public MoveCommand(String name, String shortcut, String details, String help, String dir, String speed) {
		super(name, shortcut, details, help);
		this.dir = dir;
		this.vel = Integer.parseInt(speed);
	}

	public boolean execute(Game game) throws CommandExecuteException {

		if (!game.move(dir, vel)) {
			throw new CommandExecuteException("Navi can't reach that place");
		}
		return true;
	}

	public Command parse(String[] commandWord) throws CommandParseException, CommandMovementException {
		if (!matchCommandName(commandWord[0])) {
			return null;
		} else if (commandWord.length != 3) {
			throw new CommandParseException(Command.incorrectNumArgsMsg);
		} else if (!commandWord[1].equals("1")) {
			if (!commandWord[1].equals("2")) {
				throw new CommandMovementException("I don't understand that speed");
			}
		} else if (!commandWord[2].equalsIgnoreCase("left") && !commandWord[2].equalsIgnoreCase("right")) {
			throw new CommandMovementException("I don't understand that direction");
		}
		return new MoveCommand(name, shortcut, details, help, commandWord[2], commandWord[1]);
	}

}
