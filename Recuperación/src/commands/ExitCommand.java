package commands;

import exceptions.CommandParseException;
import logic.Game;

public final class ExitCommand extends Command {

    public ExitCommand(String name, String shortcut, String details, String help) {
        super(name, shortcut, details, help);
    }

    public boolean execute(Game game) {
        game.setExit(true);
        return false;
    }

    public Command parse(String[] commandWord) throws CommandParseException {
        if (!matchCommandName(commandWord[0])) {
            return null;
        } else if (commandWord.length != 1) {
            throw new CommandParseException(Command.incorrectNumArgsMsg);
        }
        return new ExitCommand(name, shortcut, details, help);
    }

}