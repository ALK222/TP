package commands;

import exceptions.CommandParseException;
import logic.Game;

public final class ExitCommand extends Command {

    private static String _name = "Exit";

    private static String _shortcut = "E";

    private static String _details = "Exits the game";

    private static String _help = "Exits the game";

    public ExitCommand(String name, String shortcut, String details, String help) {
        super(name, shortcut, details, help);
    }

    public ExitCommand() {
        super(_name, _shortcut, _details, _help);
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